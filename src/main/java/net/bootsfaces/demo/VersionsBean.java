package net.bootsfaces.demo;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;

import net.bootsfaces.listeners.AddResourcesListener;

/**
 * ManagedBean which holds the version numbers of used frameworks.
 */
@ManagedBean(value = "versions")
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
