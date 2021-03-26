/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.controller;

import fu.daos.ProductDAO;
import fu.dtos.ProductDTO;
import fu.dtos.ProductError;
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
public class CreateController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String ADMIN = "AdminController";
    private static final String CREATE = "create.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;
        response.setContentType("text/html;charset=UTF-8");
        try {
            if (request.getParameter("action").equals("CREATE")) {
                url = CREATE;
            }
            ProductDAO dao = new ProductDAO();
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String quantity = request.getParameter("quantity");
            String des = request.getParameter("des");
            String price = request.getParameter("price");
            String img = request.getParameter("img");

            boolean checkErr = false;
            ProductError error = new ProductError();
            if (id.isEmpty()) {
                error.setId("ID can not empty");
                checkErr = true;
            }
            if (name.isEmpty()) {
                error.setName("Name can not empty");
                checkErr = true;
            }
            if (des.isEmpty()) {
                error.setDes("Description can not empty");
                checkErr = true;
            }
            if (price.isEmpty()) {
                error.setPrice("Price can not empty");
                checkErr = true;
            }
            if (img.isEmpty()) {
                error.setImg("Image can not empty");
                checkErr = true;
            }
            try {
                if (Float.parseFloat(price) <= 0) {
                    error.setPrice("Price must be larger than 0");
                    checkErr = true;
                }
            } catch (Exception e) {
                error.setPrice("Price must be a number");
                checkErr = true;
            }
            if (checkErr) {
                request.setAttribute("error", error);
                url = CREATE;
            } else {
                try {
                    
                    ProductDTO dto = new ProductDTO(id, name, img, des, Float.parseFloat(price),Integer.parseInt(quantity));
                    if (dao.insert(dto)) {
                        url = ADMIN;
                    }
                } catch (Exception e) {
                    if (e.getMessage().contains("duplicate")) {
                        error.setId("ID Duplicated");
                        request.setAttribute("error", error);
                        request.getRequestDispatcher(CREATE).forward(request, response);
                    }
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
