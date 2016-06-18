/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class ManufOrderList {
    
    ArrayList<Order> manufOrderList;
    
    public ManufOrderList(){
        manufOrderList= new ArrayList<>();
    }

    public ArrayList<Order> getManufOrderList() {
        return manufOrderList;
    }

    public void setManufOrderList(ArrayList<Order> manufOrderList) {
        this.manufOrderList = manufOrderList;
    }
    
}
