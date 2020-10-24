/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bootsfaces.issues.issue918;

import java.util.ArrayList;
import java.util.List;

public class Domains {

    public Domains() {
        fillDomains();
    }

    private List<HazardOrigin_> lHazardOrigins = new ArrayList<>();

    private void fillDomains() {
        HazardOrigin_ lHazardOrigin1 = new HazardOrigin_();
        lHazardOrigin1.setCode("origin1");
        lHazardOrigin1.setText("origin1");
        HazardOrigin_ lHazardOrigin2 = new HazardOrigin_();
        lHazardOrigin2.setCode("origin2");
        lHazardOrigin2.setText("origin2");
        HazardOrigin_ lHazardOrigin3 = new HazardOrigin_();
        lHazardOrigin3.setCode("origin3");
        lHazardOrigin3.setText("origin3");

        lHazardOrigins.add(lHazardOrigin1);
        lHazardOrigins.add(lHazardOrigin2);
        lHazardOrigins.add(lHazardOrigin3);

    }

    public List<HazardOrigin_> getHazardOrigins() {
        return lHazardOrigins;
    }
}
