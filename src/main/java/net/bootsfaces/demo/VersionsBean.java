package net.bootsfaces.demo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import net.bootsfaces.listeners.AddResourcesListener;

/**
 * Bean which holds the version numbers of used frameworks.
 */
@Named(value = "versions")
@ApplicationScoped
public class VersionsBean {

    private final static String bsfVersion, jsfImplementationVersion;

    static {
        bsfVersion = AddResourcesListener.class.getPackage().getImplementationVersion();

//		primefacesVersion = RequestContext.getCurrentInstance().
//								getApplicationContext().getConfig().getBuildVersion();
//		omniFacesVersion =  Faces.class.getPackage().getImplementationVersion();

        jsfImplementationVersion = FacesContext.class.getPackage().getImplementationVersion();
    }

    public String getBsfVersion() {
        return bsfVersion;
    }

    public String getJsfImplementationVersion() {
        return jsfImplementationVersion;
    }
}
