/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.daos;

import fu.db.MyConnection;
import fu.dtos.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class UserDAO {
    
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    public String checkLogin(String userId, String password) throws Exception {
        String role = "";
        String id = "";
        String pass = "";
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        UserDTO dto = null;

        try {
            conn = MyConnection.getConnection();
            String sql = "Select IDUser, Password, Roles From Users Where IDUser = ? and Password = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userId);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                role = rs.getString("Roles");
                id = rs.getString("IDUser");
                pass = rs.getString("Password");
                dto = new UserDTO(id, pass);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return role;
    }
    public boolean insert(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert Into Users(IDUser, Password, Fullname, Roles) "
                    + "values(?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUserid());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, "USER");
            
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
