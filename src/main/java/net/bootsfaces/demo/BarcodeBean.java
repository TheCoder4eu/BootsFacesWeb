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
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;

/**
 * This bean is used by the PrimeFaces barcode demo.
 *
 * @author Stephan Rauh, http://www.beyondjava.net
 */
@ViewScoped
@ManagedBean
public class BarcodeBean implements Serializable {

    private static final long serialVersionUID = -6810958868318611791L;
    private String code39 = "1234567890128";
    private String protocol = "https://";
    private String url = "pdfviewer.net";
    private String url2 = "http://www.bootsfaces.net";
    private String emptyText = "";
    private String nonEmptyText = "Hello World";
    private String emptyTextCapital = "";
    private String nonEmptyTextCapital = nonEmptyText.toUpperCase();

    public void capitalizeURL(AjaxBehaviorEvent event) {
        url = url.toUpperCase();
        setEmptyTextCapital(emptyText == null ? "" : emptyText.toUpperCase());
        setNonEmptyTextCapital(nonEmptyText == null ? "" : nonEmptyText.toUpperCase());
    }

    public void doNothing() {
        // this method does nothing, but it's required by the unified AJAX API of BootsFaces
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getCode39() {
        return code39;
    }

    public void setCode39(String code39) {
        this.code39 = code39;
    }

    public String getCompleteURL() {
        return protocol + "www." + url;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getEmptyText() {
        return emptyText;
    }

    public void setEmptyText(String emptyText) {
        this.emptyText = emptyText;
    }

    public String getEmptyTextCapital() {
        return emptyTextCapital;
    }

    public void setEmptyTextCapital(String emptyTextCapital) {
        this.emptyTextCapital = emptyTextCapital;
    }

    public String getNonEmptyText() {
        return nonEmptyText;
    }

    public void setNonEmptyText(String nonEmptyText) {
        this.nonEmptyText = nonEmptyText;
    }

    public String getNonEmptyTextCapital() {
        return nonEmptyTextCapital;
    }

    public void setNonEmptyTextCapital(String nonEmptyTextCapital) {
        this.nonEmptyTextCapital = nonEmptyTextCapital;
    }

}
