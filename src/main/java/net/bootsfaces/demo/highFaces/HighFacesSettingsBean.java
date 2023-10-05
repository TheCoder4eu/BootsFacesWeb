package net.bootsfaces.demo.highFaces;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
@RequestScoped
public class HighFacesSettingsBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String boysType = "line";

    private String girlsType = "column";

    private List<String> chartTypes = new ArrayList<String>();

    public HighFacesSettingsBean() {
        chartTypes.add("line");
        chartTypes.add("bar");
        chartTypes.add("pie");
        chartTypes.add("column");
    }

    public String getBoysType() {
        return boysType;
    }

    public void setBoysType(String boysType) {
        this.boysType = boysType;
    }

    public String getGirlsType() {
        return girlsType;
    }

    public void setGirlsType(String girlsType) {
        this.girlsType = girlsType;
    }

    public List<String> getChartTypes() {
        return chartTypes;
    }

    public void setChartTypes(List<String> chartTypes) {
        this.chartTypes = chartTypes;
    }

    public void redraw() {
    }
}
