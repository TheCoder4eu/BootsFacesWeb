package net.bootsfaces.demo;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import net.bootsfaces.listeners.AddResourcesListener;

/**
 * ManagedBean which holds the version numbers of used frameworks.
 */
@ManagedBean(name = "versions")
@ApplicationScoped
public class VersionsBean {

    private final static String bsfVersion, jsfImplementationVersion;
//					primefacesVersion,
//					omniFacesVersion,

    static {
        bsfVersion = AddResourcesListener.class.getPackage().getImplementationVersion();
//		primefacesVersion = RequestContext.getCurrentInstance().
//								getApplicationContext().getConfig().getBuildVersion();
//		omniFacesVersion =  Faces.class.getPackage().getImplementationVersion();
        jsfImplementationVersion = FacesContext.class.getPackage().getImplementationVersion();
    }

//	public String getPrimefacesVersion() {
//		return primefacesVersion;
//	}
    public String getBsfVersion() {
        return bsfVersion;
    }

//	public String getOmnifacesversion() {
//		return omniFacesVersion;
//	}
    public String getJsfImplementationVersion() {
        return jsfImplementationVersion;
    }
}
