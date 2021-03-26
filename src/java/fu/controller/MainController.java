/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.controller;

import fu.daos.UserDAO;
import fu.dtos.LoginError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class MainController extends HttpServlet {

    private static final String LOGIN = "LoginController";
    private static final String LOGINPAGE = "login.jsp";
    private static final String LOGOUT = "LogoutController";
    private static final String REGISTER = "RegisterController";
    private static final String REGISTERPAGE = "register.jsp";
    private static final String ERROR = "error.jsp";
    private static final String EDIT = "EditController";
    private static final String EDITPRODUCT = "EditProductController";
    private static final String DELETE = "DeleteController";
    private static final String CREATE = "CreateController";
    private static final String BUY = "BuyController";
    private static final String VIEWCART = "ViewCartController";
    private static final String SUBTRACT = "SubtractCartController";
    private static final String USER = "UserController";
    private static final String CONFIRM = "ConfirmController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String url = ERROR;
        try {
            if (null == action) {
                url = LOGINPAGE;
            }
            else switch (action) {
                case "LOGIN":
                    url = LOGIN;
                    break;
                case "LOGOUT":
                    url = LOGOUT;
                    break;
                case "REGISTER":
                    url = REGISTERPAGE;
                    break;
                case "REGISACC":
                    url = REGISTER;
                    break;
                case "EDIT":
                    url = EDIT;
                    break;
                case "EDITPRO":
                    url = EDITPRODUCT;
                    break;
                case "DELETE":
                    url = DELETE;
                    break;
                case "CREATE":
                    url = CREATE;
                    break;
                case "CREATEPRO":
                    url = CREATE;
                    break;
                case "tryLogin":
                    url = LOGINPAGE;
                    break;
                case "BUY":
                    url = BUY;
                    break;
                case "ViewCart":
                    url = VIEWCART;
                    break;
                case "SUBJECT":
                    url = SUBTRACT;
                    break;
                case "Back":
                    url = USER;
                    break;
                case "confirm":
                    url = CONFIRM;
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
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
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
