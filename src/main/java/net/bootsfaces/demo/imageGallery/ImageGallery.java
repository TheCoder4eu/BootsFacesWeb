package net.bootsfaces.demo.imageGallery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class ImageGallery implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<String> images = new ArrayList<String>() {
		{
			add("http://www.11pictures.com/foto/stories/Camargue_2013_Nature/framedPreview.png");
			add("http://www.11pictures.com/foto/stories/Camargue_2013/framedPreview.png");
			add("http://www.11pictures.com/foto/stories/GreenCevennes/framedPreview.png");
		}
		private static final long serialVersionUID = 1L;
	};

	private List<String> imagePool = new ArrayList<String>() {
		{
			add("http://www.11pictures.com/foto/stories/ValleeDeLaGrandMaison_2012/framedPreview.png");
			add("http://www.11pictures.com/foto/stories/Clouds2/framedPreview.png");
			add("http://www.11pictures.com/foto/stories/BretagneFog2003/framedPreview.png");
			add("http://www.11pictures.com/foto/stories/LifeInWinter/framedPreview.png");
			add("http://www.11pictures.com/foto/stories/Alpilles_2013/framedPreview.png");
		}
		private static final long serialVersionUID = 1L;
	};
	
	private int counter=0;
	
	public int getCounter() {
		return ++counter;
	}

	public List<String> getImages() {
		return images;
	}

	public void chooseAnotherImage(String image) {
		int index = images.indexOf(image);
		String previousImage = images.get(index);
		int random = (int) Math.floor(Math.random() * imagePool.size());
		images.set(index, imagePool.get(random));
		imagePool.set(random, previousImage);
	}

	public void chooseEveryImage() {
		for (int index = 0; index < images.size(); index++) {
			String previousImage = images.get(index);
			int random = (int) Math.floor(Math.random() * imagePool.size());
			images.set(index, imagePool.get(random));
			imagePool.set(random, previousImage);
		}
	}
}
