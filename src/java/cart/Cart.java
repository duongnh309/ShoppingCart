/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import fu.daos.ProductDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import javax.naming.NamingException;

/**
 *
 * @author PC
 */
public class Cart extends HashMap<String, Integer> implements Serializable{
    public void addToCart(String id){
        if(containsKey(id)){
            replace(id, this.get(id)+1);
        }
        else{
            put(id, 1);
        }
    }
    
    public boolean removeCart(String id){
        boolean remove = false;
        if(get(id)==1){
            remove(id);
            remove = true;
        }
        else{
            replace(id, get(id)-1);
            remove = true;
        }
        return remove;
    }
    
    public double getBill() throws NamingException, SQLException{
        ProductDAO dao = new ProductDAO();
        double total = 0;
        for (String id : keySet()) {
            total += dao.getProductById(id).getPrice()*get(id);
        }
        return total;
    }
    
}
