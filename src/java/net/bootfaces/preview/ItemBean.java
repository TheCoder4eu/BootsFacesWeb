/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author droidcoder
 */
@ManagedBean
@RequestScoped
public class ItemBean {
    
    private List<Item> items;

    /**
     * Creates a new instance of ItemBean
     */
    public ItemBean() {
        items=new ArrayList<Item>();
        items.add(new Item("Pencil","P3245"));
        items.add(new Item("Book","B0563"));
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
}
