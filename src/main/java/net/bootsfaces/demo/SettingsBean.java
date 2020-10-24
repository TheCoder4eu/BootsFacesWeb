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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * A simple bean for demo purposes.
 */
@RequestScoped
@ManagedBean
public class SettingsBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private int value1;
    private int value2;

    private boolean checkbox1;
    private boolean checkbox2;
    private boolean checkbox3;
    private boolean checkbox4;

    private CharSequence sbox1;

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public boolean isCheckbox1() {
        return checkbox1;
    }

    public void setCheckbox1(boolean checkbox1) {
        this.checkbox1 = checkbox1;
    }

    public boolean isCheckbox2() {
        return checkbox2;
    }

    public void setCheckbox2(boolean checkbox2) {
        this.checkbox2 = checkbox2;
    }

    public boolean isCheckbox3() {
        return checkbox3;
    }

    public void setCheckbox3(boolean checkbox3) {
        this.checkbox3 = checkbox3;
    }

    public void action() {

    }

    public boolean isCheckbox4() {
        return checkbox4;
    }

    public void setCheckbox4(boolean checkbox4) {
        this.checkbox4 = checkbox4;
    }

    public CharSequence getSbox1() {
        return sbox1;
    }

    public void setSbox1(CharSequence sbox1) {
        System.out.println("sbox=" + sbox1);
        this.sbox1 = sbox1;
    }
}
