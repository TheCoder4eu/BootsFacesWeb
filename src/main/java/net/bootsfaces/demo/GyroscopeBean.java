package net.bootsfaces.demo;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class GyroscopeBean {
	public void onRotation() {
		System.out.println("Rotate! " + System.currentTimeMillis());
	}

}
