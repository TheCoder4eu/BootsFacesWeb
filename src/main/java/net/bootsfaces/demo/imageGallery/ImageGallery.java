package net.bootsfaces.demo.imageGallery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.bootsfaces.utils.FacesMessages;

@ViewScoped
@ManagedBean
public class ImageGallery implements Serializable {

    private static final long serialVersionUID = 1L;

    private int oneToTen;

    private boolean showNumber;

    private List<String> images = new ArrayList<String>() {
        {
            add("Camargue_2013_Nature/framedPreview.png");
            add("Camargue_2013/framedPreview.png");
            add("GreenCevennes/framedPreview.png");
        }
        private static final long serialVersionUID = 1L;
    };

    private List<String> imagePool = new ArrayList<String>() {
        {
            add("ValleeDeLaGrandMaison_2012/framedPreview.png");
            add("Clouds2/framedPreview.png");
            add("BretagneFog2003/framedPreview.png");
            add("LifeInWinter/framedPreview.png");
            add("Alpilles_2013/framedPreview.png");
        }
        private static final long serialVersionUID = 1L;
    };

    private int counter = 0;

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

    public void validateNumber() {
        if (oneToTen >= 1 && oneToTen <= 10) {
            FacesMessages.info("oneToTenFormId:oneToTenId", "", "Well done!");
            FacesMessages.info("oneToTenFormId2:oneToTenId", "", "Well done!");
        } else if (oneToTen < 1) {
            FacesMessages.warning("oneToTenFormId:oneToTenId", "", "This number is smaller than 1.");
            FacesMessages.warning("oneToTenFormId2:oneToTenId", "", "This number is smaller than 1.");
        } else {
            FacesMessages.warning("oneToTenFormId:oneToTenId", "", "This number is larger than 10.");
            FacesMessages.warning("oneToTenFormId2:oneToTenId", "", "This number is larger than 10.");
        }
    }

    public int getOneToTen() {
        return oneToTen;
    }

    public void setOneToTen(int oneToTen) {
        this.oneToTen = oneToTen;
    }

    public boolean isShowNumber() {
        return showNumber;
    }

    public void setShowNumber(boolean showNumber) {
        this.showNumber = showNumber;
    }
}
