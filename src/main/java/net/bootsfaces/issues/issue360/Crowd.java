package net.bootsfaces.issues.issue360;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.bootsfaces.utils.FacesMessages;

@ManagedBean
@ViewScoped
public class Crowd implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Person> crowd = new ArrayList<Person>();

	public Crowd() {
		try {
			List<String> names = new ArrayList<String>();
			// copy the Names.getNames() array because we want to delete items
			// to avoid duplicates
			for (String name: Names.getNames()) {
				names.add(name);
			}; ;
			for (int i = 0; i < 200; i++) {
				int index = (int) (Math.random() * names.size());
				String name = names.get(index);
				names.remove(index);
				int pos = name.lastIndexOf(' ');
				Person p = new Person();
				p.setFirstName(name.substring(0,  pos).trim());
				p.setLastName(name.substring(pos).trim());
				crowd.add(p);
			}
		} catch (IOException e) {
			FacesMessages.error("Couldn't read the list of test names");
		}
	}

	public List<Person> getCrowd() {
		return crowd;
	}
}
