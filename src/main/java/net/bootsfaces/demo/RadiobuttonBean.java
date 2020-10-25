/**
 *  (C) 2013-2014 Stephan Rauh http://www.beyondjava.net
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.bootsfaces.demo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import net.bootsfaces.utils.FacesMessages;

/**
 * A simple bean for demo purposes.
 */
@RequestScoped
@ManagedBean
public class RadiobuttonBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private int javaVersion = 1;

    private String favoriteColor;

    private String favoriteBand;

    private Map<String, String> bands = new HashMap<String, String>();

    public RadiobuttonBean() {
        getBands().put("Arch Enemy", "melodic death metal");
        getBands().put("Blind Guardian", "speed metal");
        getBands().put("Fields of the Nephilim", "gothic metal");
        getBands().put("Led Zeppelin  (disabled)", "rock");
    }

    public int getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(int javaVersion) {
        this.javaVersion = javaVersion;
    }

    public void submit() {
        FacesMessages.info("Thanks! Your choice was " + javaVersion);
    }

    public void submitColor() {
        if (favoriteColor == null || favoriteColor.equals("")) {
            FacesMessages.warning("@property(radiobuttonBean.favoriteColor)", "", "You seem to be a bit indecisive.");
        } else if (favoriteColor.equals("Red")) {
            FacesMessages.error("@property(radiobuttonBean.favoriteColor)", "",
                    "Let me guess: you didn't think of traffic lights?");
        } else if (favoriteColor.equals("Green")) {
            FacesMessages.info("@property(radiobuttonBean.favoriteColor)", "", "Someone ordered green?");
        } else if (favoriteColor.equals("Blue")) {
            FacesMessages.info("@property(radiobuttonBean.favoriteColor)", "",
                    "Blue oceans are always nice to look at. Not to mention blue eyes. Or is it just that you've got the blues?");
        }
    }

    public void submitBand() {
        if (favoriteBand == null || favoriteBand.equals("")) {
            FacesMessages.warning("@property(radiobuttonBean.favoriteBand)", "", "You seem to be a bit indecisive.");
        } else {
            FacesMessages.info("@property(radiobuttonBean.favoriteBand)", "", "So you like " + favoriteBand + ".");
        }
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public Map<String, String> getBands() {
        return bands;
    }

    public void setBands(Map<String, String> bands) {
        this.bands = bands;
    }

    public String getFavoriteBand() {
        return favoriteBand;
    }

    public void setFavoriteBand(String favoriteBand) {
        this.favoriteBand = favoriteBand;
    }

}
