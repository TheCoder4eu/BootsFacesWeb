package issue908;
import java.io.Serializable;
import java.util.Date;

public class Flete implements Serializable {
    
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
        
    private double combustible;
    
    private double viaticos;

    private Date updated;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCombustible() {
		return combustible;
	}

	public void setCombustible(double combustible) {
		this.combustible = combustible;
	}

	public double getViaticos() {
		return viaticos;
	}

	public void setViaticos(double viaticos) {
		this.viaticos = viaticos;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Flete(int id, String name) {
		this.id = id;
		this.name = name;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}