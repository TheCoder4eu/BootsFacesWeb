package net.bootsfaces.issues.issue918;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Issue918 implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Hazard> hazards = new ArrayList<>();

	private List<Hazard> potentialHazards = new ArrayList<>();

	private Hazard selectedHazard = null;

	public Issue918() {
		getHazards().add(new Hazard("1", "Fire"));
		getHazards().add(new Hazard("2", "Inundation"));
		getHazards().add(new Hazard("3", "Traffic"));

		getPotentialHazards().add(new Hazard("4", "Storm"));
		getPotentialHazards().add(new Hazard("5", "Drought"));
		getPotentialHazards().add(new Hazard("6" ,"Famine"));
	}

	public List<Hazard> getHazards() {
		return hazards;
	}

	public void setHazards(List<Hazard> hazards) {
		this.hazards = hazards;
	}

	public void addNewHazard(Hazard selectedHazard) {
		hazards.add(selectedHazard);
	}

	public List<Hazard> getPotentialHazards() {
		return potentialHazards;
	}

	public void setPotentialHazards(List<Hazard> potentialHazards) {
		this.potentialHazards = potentialHazards;
	}

	public Hazard getSelectedHazard() {
		return selectedHazard;
	}

	public void setSelectedHazard(Hazard selectedHazard) {
//		if (!"(Please select)".equals(selectedHazard)) {
			this.selectedHazard = selectedHazard;
//		}
	}
}
