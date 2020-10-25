/**
 *  (C) 2013-2017 Stephan Rauh http://www.beyondjava.net
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
import javax.faces.view.ViewScoped;

/**
 * This bean is used by the InputText demo.
 *
 * @author Stephan Rauh, http://www.beyondjava.net
 */
@ViewScoped
@ManagedBean
public class InputTextBean implements Serializable {

    private static final long serialVersionUID = -6810958868318611791L;
    private String text = "";

    private String capitalText = "VALUE";

    private Map<String, String> map = new HashMap<String, String>();

    public String getKey() {
        return "key";
    }

    public InputTextBean() {
        getMap().put("key", "value");
    }

    public void capitalizeText() {
        setCapitalText(getMap().get("key").toUpperCase());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCapitalText() {
        return capitalText;
    }

    public void setCapitalText(String capitalText) {
        this.capitalText = capitalText;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
