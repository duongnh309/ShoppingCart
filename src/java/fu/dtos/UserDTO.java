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
public class UserDTO {
    private String userid;
    private String password;
    private String fullname;

    

    

    public UserDTO() {
    }

    public UserDTO(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }
    public UserDTO(String userid, String password, String fullname) {
        this.userid = userid;
        this.password = password;
        this.fullname = fullname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
}
