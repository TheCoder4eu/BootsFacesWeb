package net.bootsfaces.menu;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ComponentListBean {

	private String filter = null;
	
	private String[] filteredTags = ComponentList.tags;
	
	public String[] getTags() {
		return filteredTags;
	}
	
	public String url(String component) {
		return ComponentList.docFiles.get(component);
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		if (filter == null || filter.trim().equals("")) {
			filteredTags = ComponentList.tags;
			this.filter = filter;
		} else {
			if (filter.equals(this.filter)) {
				return;
			}
			this.filter = filter;
			String smallFilter = filter.toLowerCase().trim();
			List<String> result = new ArrayList<>(ComponentList.tags.length);
			for (String s: ComponentList.tags) {
				if (s.toLowerCase().contains(smallFilter)) {
					result.add(s);
				}
			}
			filteredTags = result.toArray(new String[result.size()]);
		}
	}

	public String[] getFilteredTags() {
		return filteredTags;
	}

	public void setFilteredTags(String[] filteredTags) {
		this.filteredTags = filteredTags;
	}
	
	public void updateFilter() {	}
}
