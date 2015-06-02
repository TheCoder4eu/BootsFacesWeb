package net.bootsfaces.demo;

import java.io.Serializable;
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
public class ItemBean implements Serializable {
    
    private static final Item[] itemList = new Item[]{
        new Item("Pencil","P3245","0,49 $"),
        new Item("Book","B0563","4,95 $"),
        new Item("Tablet","T3245","139,00 $"),
        new Item("Mobile","M0563","99,00 $"),
        new Item("Usb Key","U3245","10,00 $"),
        new Item("SD Card","S0563","5,00 $"),
        new Item("Hard Disk","P3245","79,99 $"),
        new Item("eBook","E0563","1,00 $"),
        new Item("Graphic Card","G3245","123,00 $"),
        new Item("RAM Module","R0563","44,00 $")
    };
    
    private DataModel<Item> items = new ArrayDataModel<Item>(itemList);
    
    
    public DataModel<Item> getItems() {
        return items;
    }

    public void setItems(DataModel<Item> items) {
        this.items = items;
    }
    
}
