package net.bootsfaces.demo.selectOneMenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

/**
 * Example taken from : https://memorynotfound.com/using-custom-converter-for-hselectonemenu/
 */
@ManagedBean
@javax.faces.bean.ViewScoped
public class BeersBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3192521384162408966L;
	private Beer selectedBeer;
	private Beer selectedBeer2;

	public Beer getSelectedBeer2() {
		return selectedBeer2;
	}

	public void setSelectedBeer2(Beer selectedBeer2) {
		this.selectedBeer2 = selectedBeer2;
	}

	private List<Beer> beers;

	public BeersBean() {
		_init();
	}

	public void _init() {
		beers = new ArrayList<Beer>();
		beers.add(new Beer(10, "La Chouffe"));
		beers.add(new Beer(20, "Stella Artois"));
		beers.add(new Beer(30, "Westmalle Trippel"));
	}

	public Beer getSelectedBeer() {
		return selectedBeer;
	}

	public void setSelectedBeer(Beer selectedBeer) {
		System.out.println("set:" + selectedBeer);
		this.selectedBeer = selectedBeer;
	}

	public List<Beer> getBeers() {
		return beers;
	}

	public void setBeers(List<Beer> beers) {
		this.beers = beers;
	}

	public Beer getBeer(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("no id provided");
		}
		for (Beer beer : beers) {
			if (id.equals(beer.getId())) {
				return beer;
			}
		}
		return null;
	}
}