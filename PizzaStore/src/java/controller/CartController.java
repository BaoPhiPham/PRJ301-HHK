/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import entity.Account;
import entity.CartItem;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PhamBaoPhi
 */
public class CartController extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession se = request.getSession();
        Account ac = (Account) se.getAttribute("account");
        if (ac == null) {
            response.sendRedirect("login");
            return;
        }
        DAO dao = new DAO();
        List<CartItem> listCart = dao.getAllProductInCartByID(ac.getAccountID());
        double totalAllProduct = 0;
        for (CartItem cartItem : listCart) {
            totalAllProduct += cartItem.getTotal();
        }
        System.out.println(listCart);
        request.setAttribute("listCart", listCart);
        request.setAttribute("totalAllProduct", totalAllProduct);
        request.getRequestDispatcher("WEB-INF/views/cart.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        try {
            String action = request.getParameter("action");
            if (action == null) {
                //return về trang add
                response.sendRedirect("manager");
                return;
            }
            action = action.trim();
            String cartItemId = request.getParameter("cartItemId");
            DAO dao = new DAO();
            int id = 0;
            if (!(cartItemId == null)) {
                id = Integer.parseInt(cartItemId);
            }
            switch (action) {
                case "update":
                    String quantityUpdate_str = request.getParameter("quantity");
                    if (quantityUpdate_str == null) {
                        quantityUpdate_str = "0";
                    }
                    int quantityUpdate = Integer.parseInt(quantityUpdate_str.trim());
                    if(quantityUpdate == 0 ){
                        dao.removeCartItem(id);
                    }else{
                        dao.updateProductInCart(id, quantityUpdate);
                    }  
                    break;
                case "delete":
                    dao.removeCartItem(id);
                    break;
                case "add":
                    String productIdSTR = request.getParameter("productId");
                    String quantitySTR = request.getParameter("quantity");
                    if (quantitySTR == null) {
                        quantitySTR = "1";
                    }
                    if (!(productIdSTR == null)) {
                        int quantity = Integer.parseInt(quantitySTR.trim());
                        int productID = Integer.parseInt(productIdSTR.trim());
                        HttpSession se = request.getSession();
                        Account ac = (Account) se.getAttribute("account");
                        dao.addItemToCart(ac.getAccountID(), productID, quantity);
                    }
                    break;
                default:
                    throw new Exception();
            }
            response.sendRedirect("cart");
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("cart");
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
