/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.daos;

import fu.db.MyConnection;
import fu.dtos.ProductDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author PC
 */
public class ProductDAO implements Serializable {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ProductDTO> getAllProducts() throws NamingException, SQLException {
        ArrayList<ProductDTO> list = null;
        ProductDTO dto = null;
        String sql = "Select * from Item where stt = 'true' ";
        try {
            conn = MyConnection.getConnection();
            if (conn != null) {
                list = new ArrayList<>();
                preStm = conn.prepareStatement(sql);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("IDItem");
                    String name = rs.getString("ItemName");
                    String description = rs.getString("description");
                    String image = rs.getString("image");
                    float price = rs.getFloat("Price");
                    int quantity = rs.getInt("Quantity");
                    dto = new ProductDTO(id, name, image, description, price, quantity);
                    list.add(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public ProductDTO getProductById(String ID) throws NamingException, SQLException {
        ArrayList<ProductDTO> list = null;
        ProductDTO dto = null;
        String sql = "Select IDItem, ItemName , description, image, Price from Item Where IDItem = ?";
        try {
            conn = MyConnection.getConnection();
            if (conn != null) {
                list = new ArrayList<>();
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, ID);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("IDItem");
                    String name = rs.getString("ItemName");
                    String description = rs.getString("description");
                    String image = rs.getString("image");
                    float price = rs.getFloat("Price");
                    dto = new ProductDTO(id, name, image, description, price);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return dto;
    }

    public int getQuantityByID(String id) throws NamingException, SQLException, ClassNotFoundException, Exception {
        int quantity = 0;
        try {
            String sql = "select Quantity from Item where IDItem = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt(1);
            }
        } finally {
            closeConnection();
        }
        return quantity;
    }

    public float getPriceById(String idPro) throws SQLException, ClassNotFoundException, Exception {
        float price = -1;
        String sql = "select Price from Item where IDItem = ?";
        try {
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, idPro);
            rs = preStm.executeQuery();
            if (rs.next()) {
                price = rs.getFloat(1);
            }
        } finally {
            closeConnection();
        }
        return price;
    }

    public boolean updateQuantity(String proId, int quantity) throws ClassNotFoundException, SQLException, Exception {
        boolean update = false;
        try {
            String sql = "update Item set Quantity = ? where IDItem = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, quantity);
            preStm.setString(2, proId);
            update = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return update;
    }

    public boolean insert(ProductDTO product) throws NamingException, SQLException, ClassNotFoundException, Exception {
        String sql = "Insert Into Item values(?,?,?,?,?,?,?)";
        boolean check = false;
        String stt = "true";
        try {
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, product.getIdProduct());
            preStm.setString(2, product.getNameProduct());
            preStm.setFloat(3, product.getPrice());
            preStm.setString(4, product.getImage());
            preStm.setString(5, product.getDescription());
            preStm.setInt(6, product.getQuantity());
            preStm.setString(7, stt);
            check = preStm.executeUpdate() > 0;

        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(ProductDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "update Item set ItemName = ?, description = ?, "
                    + "Price = ?, image = ? "
                    + "where IDItem = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getNameProduct());
            preStm.setString(2, dto.getDescription());
            preStm.setFloat(3, dto.getPrice());
            preStm.setString(4, dto.getImage());
            preStm.setString(5, dto.getIdProduct());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "update Item set stt = 'false' where IDItem = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

}
