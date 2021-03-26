/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.dtos;

/**
 *
 * @author PC
 */
public class OrderDetailDTO {
    private String idOrder;
    private String idItem;
    private int quantity;
    private float price;

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public OrderDetailDTO(String idOrder, String idItem, int quantity, float price) {
        this.idOrder = idOrder;
        this.idItem = idItem;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetailDTO() {
    }
}
