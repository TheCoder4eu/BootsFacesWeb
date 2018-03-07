package net.bootsfaces.issues.issue918;

public class Hazard {
	private String id;
	private String origin;

	public Hazard(String id, String origin) {
		this.setId(id);
		this.setOrigin(origin);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

}
