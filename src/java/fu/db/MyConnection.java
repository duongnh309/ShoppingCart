/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author PC
 */
public class MyConnection implements Serializable{
    public static Connection getConnection() throws Exception{
       //1
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       //2
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Assignment","sa","duongparkun123");
        return conn;

    }
}
