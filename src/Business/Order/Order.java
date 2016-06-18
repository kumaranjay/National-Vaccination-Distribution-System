/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Vaccine.Vaccine;
import java.util.ArrayList;

/**
 *
 * @author Danisha
 */
public class Order {
    
    private int orderId;
    private String status;
    public static int count=1;
    private ArrayList<OrderItem> orderItemList;
    
    public Order(){
        orderItemList= new ArrayList<OrderItem>();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    
    public int getOrderId() {
        return orderId;
    }
    
    public OrderItem addOrder(Vaccine vaccine, int quantity, float salesPrice){
        OrderItem orderItem= new OrderItem();
        orderItem.setVaccine(vaccine);
        orderItem.setQuantity(quantity);
        orderItem.setSalesPrice(salesPrice);
        orderItemList.add(orderItem);
        return orderItem;
    }
    
    public void removeOrder(OrderItem orderItem){
        orderItemList.remove(orderItem);
    }

    @Override
    public String toString() {
        return Integer.toString(orderId) ;
    }

    
}
