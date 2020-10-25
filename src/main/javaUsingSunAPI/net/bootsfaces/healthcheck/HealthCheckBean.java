package net.bootsfaces.healthcheck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.sun.jdi.Bootstrap;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector.Argument;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;

/**
 * Utility class for cyclic logging of VM metrics. Logs instance count per class
 * and names of threads. </br>
 * The remote JVM has to be started in debugging mode with socket transport
 * enabled, e.g.
 * <code>-Xdebug -Xrunjdwp:transport=dt_socket,address=3001,server=y,suspend=n</code>
 *
 * @author auster
 */
//@ApplicationScoped
//@ManagedBean(eager=false)
public class HealthCheckBean {

    private VirtualMachine vm = null;

    private List<ObjectDescription> mostFrequentObjects = null;

    private long lastcheck = 0;

    private String errormessage = "";

    public HealthCheckBean() throws IOException, IllegalConnectorArgumentsException {
        try {
            AttachingConnector ac = null;
            for (final Object x : Bootstrap.virtualMachineManager().attachingConnectors()) {
                if (x.getClass().getName().toLowerCase().indexOf("socket") != -1) {
                    ac = (AttachingConnector) x;
                    break;
                }
            }
            if (ac == null) {
                throw new Error("No socket attaching connector found");
            }
            final Map<String, Argument> connectArgs = new HashMap<String, Argument>(ac.defaultArguments());
            connectArgs.get("hostname").setValue("127.0.0.1");
            connectArgs.get("port").setValue(Integer.toString(3001));
            connectArgs.get("timeout").setValue("3000");
            vm = ac.attach(connectArgs);
        } catch (Exception error) {
            errormessage = error.getClass().getName() + " " + error.getMessage();
        }

    }

    public String reportMostFrequentObjects() {
        if (null == vm) {
            FacesMessage fm = new FacesMessage("Couldn't attach to the virtual machine: " + errormessage);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {

            if (System.currentTimeMillis() - lastcheck >= 10000) {
                synchronized (HealthCheckBean.class) {
                    lastcheck = System.currentTimeMillis();
                    long start = System.nanoTime();
                    ArrayList<ObjectDescription> result = new ArrayList<>();
                    try {
                        final List<ReferenceType> allClasses = vm.allClasses();
                        final long[] instanceCounts = vm.instanceCounts(allClasses);
                        for (int i = 0; i < allClasses.size(); i++) {
                            if (allClasses.get(i).name().contains("bootsfaces")
                                    || allClasses.get(i).name().contains("angularfaces")
                                    || allClasses.get(i).name().contains("beyondjava")) {
                                ObjectDescription desc = new ObjectDescription();
                                desc.setName(allClasses.get(i).name());
                                desc.setCount(instanceCounts[i]);
                                result.add(desc);
                            }
                        }
                        // Collections.sort(result, new
                        // Comparator<ObjectDescription>()
                        // {
                        //
                        // @Override
                        // public int compare(ObjectDescription o1,
                        // ObjectDescription
                        // o2) {
                        // long delta = o1.getCount()-o2.getCount();
                        // if (delta<0) return +1;
                        // if (delta==0) return 0;
                        // return -1;
                        // }
                        //
                        // });
                        // vm.dispose();

                        System.out.println(((System.nanoTime() - start) / 1000) / 1000.0 + "ms");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    setMostFrequentObjects(result);
                }
            }
        }
        return "";
    }

    public List<ObjectDescription> getMostFrequentObjects() {
        return mostFrequentObjects;
    }

    public void setMostFrequentObjects(List<ObjectDescription> mostFrequentObjects) {
        this.mostFrequentObjects = mostFrequentObjects;
    }
}
