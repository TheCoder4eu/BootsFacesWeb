package net.bootsfaces.demo.highFaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LineChartBean {

    protected List<Birth> boys;
    protected List<Birth> girls;

    public List<Birth> getBoys() {
        return boys;
    }

    public List<Birth> getGirls() {
        return girls;
    }

    public LineChartBean() {
        reload();
    }

    private void reload() {
        boys = new ArrayList<>();
        girls = new ArrayList<>();
        Random r = new Random();
        for (int i = 2000; i < 2010; i++) {
            boys.add(new Birth(Integer.toString(i), r.nextInt(500) + 800));
            girls.add(new Birth(Integer.toString(i), r.nextInt(500) + 800));
        }
    }
}
