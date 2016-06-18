/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Inventory.Inventory;
import Business.Vaccine.Vaccine;

/**
 *
 * @author Danisha
 */
public class OrderItem {

    private int quantity;
    private Inventory inventory;
    private float salesPrice;
    private Vaccine vaccine;

    public OrderItem() {
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public float getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(float salesPrice) {
        this.salesPrice = salesPrice;
    }

    /* @Override
     public String toString() {
     return inventory.getProductName();
     }*/
}
