/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.daos;

import fu.db.MyConnection;
import fu.dtos.OrderDTO;
import fu.dtos.OrderDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class OrderDAO {
    Connection cn;
    PreparedStatement pst;
    ResultSet rs;

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (pst != null) {
            pst.close();
        }
        if (cn != null) {
            cn.close();
        }
    }
    public int getOrderId() throws ClassNotFoundException, SQLException, Exception{
        int orderId = -1;
        String sql = "select IDOrder from tblOrder where Date = (select max(Date) from tblOrder)";
        String id = "";
        try {
            cn = MyConnection.getConnection();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                id = rs.getString(1);
            }
            if(!id.isEmpty()){
                orderId = Integer.parseInt(id)+1;
            }
            else orderId = 1;
        } finally{
            closeConnection();
        }
        return orderId;
    }
    public boolean addOrder(OrderDTO order, ArrayList<OrderDetailDTO> detailList) throws SQLException, ClassNotFoundException, Exception{
        try {
            
            cn=MyConnection.getConnection();
            cn.setAutoCommit(false);
            String sql = "insert into tblOrder values(?,?,?,?)";
            pst = cn.prepareStatement(sql);
            pst.setString(1, order.getId());
            pst.setString(2, order.getDate());
            pst.setString(3, order.getIdUser());
            pst.setString(4, order.getPayment());
            if(pst.executeUpdate()>0){
                for (OrderDetailDTO orderDetailDTO : detailList) {
                    String sql1 = "insert into DetailOrder values(?,?,?,?)";
                    pst = cn.prepareStatement(sql1);
                    pst.setString(1, orderDetailDTO.getIdOrder());
                    pst.setString(2, orderDetailDTO.getIdItem());
                    pst.setInt(3, orderDetailDTO.getQuantity());
                    pst.setFloat(4, orderDetailDTO.getPrice());
                    
                    if(pst.executeUpdate() > 0){
                        
                    }
                }
                cn.commit();
                return true;
            }
        } finally{
            closeConnection();
        }
        
        return false;
    }
    
}
