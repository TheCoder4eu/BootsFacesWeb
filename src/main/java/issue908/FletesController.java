package issue908;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class FletesController implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<SelectItem> tipos;

	private SelectItem selectedFlete = new SelectItem("02", "Steel");

	public FletesController() {
		tipos = new ArrayList<>();
		getTipos().add(new SelectItem("01", "Wood"));
		getTipos().add(new SelectItem("02", "Steel"));
		getTipos().add(new SelectItem("03", "Plastic"));
	}

	// Listener in b:dataTable commandButton
	public void onEdit(SelectItem flete) {
       setSelectedFlete(new SelectItem("03", "Plastic"));
    }

	public SelectItem getSelectedFlete() {
		return selectedFlete;
	}

	public void setSelectedFlete(SelectItem selectedFlete) {
		this.selectedFlete = selectedFlete;
	}

	public List<SelectItem> getTipos() {
		return tipos;
	}

	public void setTipos(List<SelectItem> tipos) {
		this.tipos = tipos;
	}
}
