package net.bootsfaces.issues.issue918;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Issue918 implements Serializable
{
    Domains domains = new Domains();

    private List<Hazard_> hazards = new ArrayList<>();

    HazardType_ lHazardType1 = new HazardType_();
    HazardType_ lHazardType2 = new HazardType_();
    HazardType_ lHazardType3 = new HazardType_();

    public Issue918()
    {
    	initialise();
    }

    
    private void initialise()
    {
        lHazardType1.setCode("type1");
        lHazardType1.setText("type1");
        lHazardType1.setHazardOrigins(domains.getHazardOrigins());
        lHazardType2.setCode("type2");
        lHazardType2.setText("type2");
        lHazardType2.setHazardOrigins(domains.getHazardOrigins());
        lHazardType3.setCode("type3");
        lHazardType3.setText("type3");
        lHazardType3.setHazardOrigins(domains.getHazardOrigins());

        Hazard_ lHazard1 = new Hazard_();
        lHazard1.setType(lHazardType1);
        getHazards().add(lHazard1);
        Hazard_ lHazard2 = new Hazard_();
        lHazard2.setType(lHazardType2);
        getHazards().add(lHazard2);
        Hazard_ lHazard3 = new Hazard_();
        lHazard3.setType(lHazardType3);
        getHazards().add(lHazard3);

    }

    public List<Hazard_> getHazards()
    {
        return hazards;
    }

    public void setHazards(List<Hazard_> hazards)
    {
        this.hazards = hazards;
    }

    public void addNewHazard()
    {
        Hazard_ lHazard = new Hazard_();
        lHazard.setType(lHazardType1);
        hazards.add(lHazard);
    }
}
