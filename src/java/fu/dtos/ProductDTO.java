/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.dtos;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class ProductDTO implements Serializable{
    private String idProduct;
    private String nameProduct;
    private String image;
    private String description;
    private float price;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductDTO(String idProduct, String nameProduct, String image, String description, float price, int quantity) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    public ProductDTO(String idProduct, String nameProduct, String image, String description, float price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.image = image;
        this.description = description;
        this.price = price;
    }
    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    

    public ProductDTO() {
    }
    
}
