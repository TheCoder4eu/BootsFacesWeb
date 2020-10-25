package net.bootsfaces.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ComponentListBean {

    private Map<String, String> allConcepts = new HashMap<>();
    private Map<String, String> filteredConcepts = new HashMap<>();

    private String filter = null;

    private String[] filteredTags = ComponentList.tags;

    public ComponentListBean() {
        allConcepts.put("Grid system", "layout/basic.jsf");
        allConcepts.put("PrimeFaces", "integration/PrimeFaces.jsf");
        allConcepts.put("Converters", "forms/converters.jsf");
        allConcepts.put("AJAX", "forms/ajax.jsf");
        allConcepts.put("Search expressions", "forms/searchExpressions.jsf");
        allConcepts.put("BlockUI", "forms/blockUI.jsf");
        allConcepts.put("Fontawesome 5", "layout/fontawesome5.jsf");
        filteredConcepts = allConcepts;
    }

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
            filteredConcepts = allConcepts;
        } else {
            filter = filter.replace("<b:", "<");
            if (filter.equals(this.filter)) {
                return;
            }
            this.filter = filter;
            String smallFilter = filter.toLowerCase().trim();
            List<String> result = new ArrayList<>(ComponentList.tags.length);
            for (String s : ComponentList.tags) {
                if (s.toLowerCase().contains(smallFilter)) {
                    result.add(s);
                }
            }
            final String finalFilter = filter.toLowerCase();
            filteredTags = result.toArray(new String[result.size()]);
            filteredConcepts = new HashMap<>();
            allConcepts.forEach((name, url)
                    -> {
                if (name.toLowerCase().contains(finalFilter)) {
                    filteredConcepts.put(name, url);
                }
            });
        }
    }

    public String[] getFilteredTags() {
        return filteredTags;
    }

    public void setFilteredTags(String[] filteredTags) {
        this.filteredTags = filteredTags;
    }

    public void updateFilter() {
    }

    public String getDisplayName(String c) {
        c = c.replace("<", "").replace(">", "");
        c = c.substring(0, 1).toUpperCase() + c.substring(1);
        return c;
    }

    public String addSlashIfNecessary(String path) {
        if (path.endsWith("/")) {
            return path;
        }
        return path + "/";
    }

    public Map<String, String> getFilteredConcepts() {
        return filteredConcepts;
    }
}
