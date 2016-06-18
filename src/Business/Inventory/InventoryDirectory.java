/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Inventory;

import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class InventoryDirectory {
    
    private ArrayList<Inventory> inventoryList;
    
    public InventoryDirectory(){
        inventoryList= new ArrayList<>();
    }

    public ArrayList<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
    
    
}
