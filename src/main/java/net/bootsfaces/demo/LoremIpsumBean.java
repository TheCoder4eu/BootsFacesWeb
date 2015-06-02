package net.bootsfaces.demo;

/**
 * Managed Bean for Items
 * @author Thecoder4.eu
 */

import java.io.Serializable;
import java.util.StringTokenizer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;

/**
 * Data Model Bean for Items
 * @author Thecoder4.eu
 */
@ManagedBean
@RequestScoped
public class LoremIpsumBean implements Serializable {
    
    public static final String loremipsum="Lorem ipsum dolor sit amet "
            + "consectetur adipiscing elit sed "
            + "do eiusmod tempor incididunt "
            + "ut labore et dolore magna aliqua "
            + "Ut enim ad minim veniam "
            + "quis nostrud exercitation ullamco laboris "
            + "nisi ut aliquip ex ea commodo consequat "
            + "Duis aute irure dolor in reprehenderit in voluptate "
            + "velit esse cillum dolore eu fugiat nulla pariatur "
            + "Excepteur sint occaecat cupidatat non proident "
            + "sunt in culpa qui officia deserunt mollit anim id est laborum";
    
    private static LoremItem[] itemList;
    private DataModel<LoremItem> items;

    public LoremIpsumBean() {
        StringTokenizer st = new StringTokenizer(loremipsum);
        itemList = new LoremItem[]{
            new LoremItem("1,001", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
            new LoremItem("1,002", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
            new LoremItem("1,003", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
            new LoremItem("1,004", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
            new LoremItem("1,005", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
            new LoremItem("1,006", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
            new LoremItem("1,007", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
            new LoremItem("1,008", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
            new LoremItem("1,009", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
            new LoremItem("1,010", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
            new LoremItem("1,011", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
            new LoremItem("1,012", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
            new LoremItem("1,013", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
            new LoremItem("1,014", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
            new LoremItem("1,015", st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken())
        };
        items = new ArrayDataModel<LoremItem>(itemList);
    }
    
    public DataModel<LoremItem> getItems() {
        return items;
    }

    public void setItems(DataModel<LoremItem> items) {
        this.items = items;
    }
    
}
