/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.controller;

import cart.Cart;
import fu.daos.OrderDAO;
import fu.daos.OrderDetailDAO;
import fu.daos.ProductDAO;
import fu.dtos.OrderDTO;
import fu.dtos.OrderDetailDTO;
import fu.dtos.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
public class ConfirmController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try {
            OrderDAO orderDAO = new OrderDAO();
            ProductDAO proDAO = new ProductDAO();

            int Orderid = orderDAO.getOrderId();

            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");

            Timestamp timeStamp = new Timestamp(new Date().getTime());
            String dateCreate = timeStamp.toString();
            String paymentMethod = request.getParameter("selection");
            String userId = (String) session.getAttribute("ID");
            OrderDTO order = new OrderDTO(Orderid + "", dateCreate, userId, paymentMethod);
            ArrayList<OrderDetailDTO> detailList = new ArrayList<>();
            for (String proId : cart.keySet()) {
                ProductDTO product = proDAO.getProductById(proId);
                int proQuantity = proDAO.getQuantityByID(proId);
                int buyQuantity = cart.get(proId);
                if (proQuantity >= buyQuantity) {
                    detailList.add(new OrderDetailDTO(Orderid + "", proId, cart.get(proId), product.getPrice() * cart.get(proId)));
                    orderDAO.addOrder(order, detailList);
                    int currentQuantity = proDAO.getQuantityByID(proId);
                    currentQuantity -= cart.get(proId);
                    proDAO.updateQuantity(proId, currentQuantity);
                    session.removeAttribute("CART");
                }
                else{
                    request.setAttribute("QuantityError", "Product do not enough to sell");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher("UserController").forward(request, response);
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
            Logger.getLogger(ConfirmController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ConfirmController.class.getName()).log(Level.SEVERE, null, ex);
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
