/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.controller;

import fu.daos.UserDAO;
import fu.dtos.RegisterError;
import fu.dtos.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String LOGIN = "login.jsp";
    private static final String REGISTER = "register.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id = request.getParameter("idUser");
            String pass = request.getParameter("pass");
            String pass2 = request.getParameter("pass2");
            String name = request.getParameter("name");

            boolean checkRegister = false;

            RegisterError error = new RegisterError();
            if (id.isEmpty()) {
                error.setIdError("ID can not blank");
                checkRegister = true;
            }
            if (pass.isEmpty()) {
                error.setPassError("Password can not blank");
                checkRegister = true;
            }
            if (pass2.isEmpty()) {
                error.setPass2Error("The retype password can not blank");
                checkRegister = true;
            }
            if (!pass.equals(pass2)) {
                error.setPass2Error("Retype wrong password");
                checkRegister = true;
            }
            if (name.isEmpty()) {
                error.setFullname("Fullname can not blank");
                checkRegister = true;
            }
            if (checkRegister) {
                request.setAttribute("ErrorObj", error);
                request.getRequestDispatcher(REGISTER).forward(request, response);
            }

            if (!checkRegister) {
                UserDTO dto = new UserDTO(id, pass2, name);
                try {
                    UserDAO dao = new UserDAO();
                    if (dao.insert(dto)) {
                        request.getRequestDispatcher(LOGIN).forward(request, response);
                    }
                } catch (Exception e) {
                    if (e.getMessage().contains("duplicate")) {
                        error.setIdError("ID duplicated");
                        request.setAttribute("ErrorObj", error);
                        request.getRequestDispatcher(REGISTER).forward(request, response);
                    }
                }
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
