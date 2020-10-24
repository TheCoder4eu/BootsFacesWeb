package net.bootsfaces.demo.layout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

@ManagedBean
@RequestScoped
public class IconAwesomeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> fontAwesomeIconList;

    @PostConstruct
    public void onload() {
        initialiseList();
    }

    private void initialiseList() {
        fontAwesomeIconList = new ArrayList<>();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

        try (InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/fontAwesomeList.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("(alias)")) {
                    line = line.substring(0, line.indexOf("(alias)"));
                }
                line = line.trim();
                fontAwesomeIconList.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(IconAwesomeBean.class.getName()).log(Level.SEVERE, "Error obtaining the list of awesome icons", ex);
        }
    }

    public List<String> getFontAwesomeIconList() {
        return fontAwesomeIconList;
    }

    public void setFontAwesomeIconList(List<String> fontAwesomeIconList) {
        this.fontAwesomeIconList = fontAwesomeIconList;
    }

}
