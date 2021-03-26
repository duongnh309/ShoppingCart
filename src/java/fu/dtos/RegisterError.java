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
public class RegisterError {
    private String idError;
    private String passError;
    private String pass2Error;
    private String fullname;

    public RegisterError() {
    }

    public RegisterError(String idError, String passError, String pass2Error, String fullname) {
        this.idError = idError;
        this.passError = passError;
        this.pass2Error = pass2Error;
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public String getPassError() {
        return passError;
    }

    public void setPassError(String passError) {
        this.passError = passError;
    }

    public String getPass2Error() {
        return pass2Error;
    }

    public void setPass2Error(String pass2Error) {
        this.pass2Error = pass2Error;
    }
    
}
