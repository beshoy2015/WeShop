/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import DBTables.DBConnection;
import DBTables.Product;
import DBTables.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TECHNOLOGY CITY
 */
public class payCart extends HttpServlet {

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

            DBConnection dBConnection;

            dBConnection = new DBConnection();
            dBConnection.connect();

            HttpSession session = request.getSession(false);

            HashMap<Product, Integer> keySend = (HashMap<Product, Integer>) session.getAttribute("allSelectedProducts");

            Double price = (Double) request.getSession(false).getAttribute("price");

            User user = (User) session.getAttribute("userInfo");
            System.out.println(user.getUserName());
            System.out.println(user.getId());

            String result = dBConnection.checkBeforeBuy(user.getId(), keySend, price);

            if (result.equals("Done")) {

                String updateDatabas = dBConnection.buyProducts(user.getId(), keySend, price);
                request.setAttribute("result", "Done Purshace you will have your products in 48 hour.<br> Thanks For using our Site ");

                Cookie[] cookie = request.getCookies();
                for (Cookie cookie1 : cookie) {
                    if((cookie1.getName()).compareTo("moustafa") == 0)
                    {
                        
//                        cookie1.setMaxAge(-1);
//                        cookie1.setPath("/");
//                        response.addCookie(cookie1);
                       cookie1.setMaxAge(0);
                       cookie1.setValue(null);
                       cookie1.setPath("/");                      
                       response.addCookie(cookie1);
                        System.out.println("cookie deleted");
                    }
                    
                }

                request.getRequestDispatcher("newjsp1.jsp").include(request, response);

            } else {
                request.setAttribute("result", result);
                request.getRequestDispatcher("newjsp1.jsp").include(request, response);

            }

            System.out.println(result);
//            request.setAttribute("result","Done Purshace you will have your products in 48 hour.<br> Thanks For using our Site ");
//            request.getRequestDispatcher("newjsp1.jsp").include(request,response);

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
