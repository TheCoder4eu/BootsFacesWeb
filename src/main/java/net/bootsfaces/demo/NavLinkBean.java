package net.bootsfaces.demo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class NavLinkBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int activePage = 0;

	private String source;

	public void navigateToPage(int page, String source) {
		activePage = page;
		this.source = source;
	}

	public String getPageTitle() {
		return "Page " + (activePage + 1);
	}

	public String getPageContent() {
		if (source == null) {
			return "This is the default page.";
		}
		if (0 == activePage)
			return "This is the first page, and you've called it using a " + source + ".";
		if (1 == activePage)
			return "This is the second page, and you've called it using a " + source + ".";
		return "This is an unknown page.";
	}

	public String getPageLook() {
		if (0 == activePage)
			return "primary";
		return "success";
	}
}
