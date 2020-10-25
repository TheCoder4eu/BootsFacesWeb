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

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import net.bootsfaces.utils.FacesMessages;

/**
 * This bean is used by the reproducer of
 * https://stackoverflow.com/questions/51831950/fvalidateregex-for-not-required-inputtext-its-possible.
 *
 * @author Stephan Rauh, http://www.beyondjava.net
 */
@ViewScoped
@ManagedBean
public class SoArxzelBean implements Serializable {

    private static final long serialVersionUID = -6810958868318611791L;
    private String text = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void action() {
        System.out.println("Action called!");
        FacesMessages.info("Código enviado: " + text);
    }
}
