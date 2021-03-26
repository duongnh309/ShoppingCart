/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.daos;

import fu.db.MyConnection;
import fu.dtos.OrderDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class OrderDetailDAO {
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
    public boolean addOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException, Exception{
        boolean add = false;
        String sql = "insert into DetailOrder values(?,?,?,?)";
        try {
            cn = MyConnection.getConnection();
            pst = cn.prepareStatement(sql);
            pst.setString(1, dto.getIdOrder());
            pst.setString(2, dto.getIdItem());
            pst.setInt(3, dto.getQuantity());
            pst.setFloat(4, dto.getPrice());
            add = pst.executeUpdate()>0;
        } finally{
            closeConnection();
        }
        return add;
    }
}
