package issue908;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CartaportesController implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean disabledToggle;
    private Cartaporte selectedCartaporte;

    private boolean disabled = true;

    private Flete flete = null;

    private Map<String, Flete> fletesMap = new HashMap<>();

    public CartaportesController() {
        fletesMap.put("- Selecciona -", null);
        fletesMap.put("Metal", new Flete(1, "Metal"));
        fletesMap.put("Wood", new Flete(2, "Wood"));
        fletesMap.put("Plastic", new Flete(3, "Plastic"));
    }

    public void populateMap() {
        flete = fletesMap.get("Wood");
    }

    public String onView() {
        return null;
    }

    public boolean getDisabledToggle() {
        return this.disabledToggle;
    }

    public void setDisabledToggle(boolean disabledToggle) {
        this.disabledToggle = disabledToggle;
    }

    public Cartaporte getSelectedCartaporte() {
        return this.selectedCartaporte;
    }

    public void setSelectedCartaporte(Cartaporte selectedCartaporte) {
        this.selectedCartaporte = selectedCartaporte;
    }

    public Map<String, Flete> getFletesMap() {
        return fletesMap;
    }

    public void setFletesMap(Map<String, Flete> fletesMap) {
        this.fletesMap = fletesMap;
    }

    public Flete getFlete() {
        return flete;
    }

    public void setFlete(Flete flete) {
        this.flete = flete;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
