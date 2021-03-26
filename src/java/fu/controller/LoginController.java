/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.controller;

import fu.daos.UserDAO;
import fu.dtos.LoginError;
import fu.dtos.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String LOGIN = "login.jsp";
    private static final String ADMIN = "AdminController";
    private static final String ERROR = "errorLogin.jsp";
    private static final String USER = "UserController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        try {
            boolean checkError = false;
            String id = request.getParameter("idUser");
            String pass = request.getParameter("pass");
            
            

            LoginError error = new LoginError();
            if (id.isEmpty()) {
                error.setIdError("User ID cant not blank");
                checkError = true;
            }
            if (pass.isEmpty()) {
                error.setPassError("Password cant not blank");
                checkError = true;
            }
            if (checkError) {
                request.setAttribute("ErrorObj", error);
                request.getRequestDispatcher(LOGIN).forward(request, response);
            }
            if (!checkError) {
                HttpSession session = request.getSession();
                session.setAttribute("ID", id);
                
                UserDAO dao = new UserDAO();
                String role = dao.checkLogin(id, pass);
                if (role.equalsIgnoreCase("ADMIN")) {
                    session.setAttribute("ROLE", "ADMIN");
                    url = ADMIN;
                }
                if (role.equalsIgnoreCase("USER")) {
                    session.setAttribute("ROLE", "USER");
                    url = USER;
                }
                if (!role.equalsIgnoreCase("ADMIN") & !role.equalsIgnoreCase("USER")) {
                    error.setError("Invalid Account");
                    request.setAttribute("ErrorObj", error);
                    url = LOGIN;
                }

            }
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
