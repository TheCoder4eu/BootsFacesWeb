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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;

/**
 * A simple bean for demo purposes.
 */
@RequestScoped
@ManagedBean
public class SemaphoreBean {

    @NotNull
    private String color = null;

    @NotNull
    private String meaning = null;

    private List<String> colors;

    private Map<String, String> meanings;

    public SemaphoreBean() {
        colors = Arrays.asList("green", "yellow", "red");
        meanings = new HashMap<>();
        meanings.put("go", "green");
        meanings.put("be alert", "yellow");
        meanings.put("stop", "red");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public Map<String, String> getMeanings() {
        return meanings;
    }

    public void setMeanings(Map<String, String> meanings) {
        this.meanings = meanings;
    }
}
