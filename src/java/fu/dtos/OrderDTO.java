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
public class OrderDTO {
    private String id;
    private String date;
    private String idUser;
    private String payment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public OrderDTO(String id, String date, String idUser, String payment) {
        this.id = id;
        this.date = date;
        this.idUser = idUser;
        this.payment = payment;
    }

    public OrderDTO() {
    }
    
}
