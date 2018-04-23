/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import DBTables.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TECHNOLOGY CITY
 */
public class ManageProducts extends HttpServlet {
    static public int checkObj=0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            

            if (request.getParameter("key").equals("M")) {
                checkObj=1;
                HttpSession session = request.getSession(false);

                HashMap<Product, Integer> keySend = (HashMap<Product, Integer>) session.getAttribute("allSelectedProducts");

                int check = Integer.parseInt(request.getParameter("id"));
                System.out.println(check);

                for (Product p : keySend.keySet()) {
                    if (p.getId() == check) {
                        if (keySend.get(p) != 0) {
                            System.out.println(keySend.get(p));
                            keySend.put(p, keySend.get(p) - 1);
                            
                            System.out.println(keySend.get(p));


                        }

                    }

                }
//              HttpSession s = request.getSession(true);
//              session.setAttribute("allSelectedProducts", keySend);
                request.getSession().setAttribute("allSelectedProducts", keySend);
//              

            }
            if (request.getParameter("key").equals("A")) {
                checkObj=1;
                HttpSession session = request.getSession(false);

                HashMap<Product, Integer> keySend = (HashMap<Product, Integer>) session.getAttribute("allSelectedProducts");

                int check = Integer.parseInt(request.getParameter("id"));

                for (Product p : keySend.keySet()) {
                    if (p.getId() == check) {
                        if (keySend.get(p) != 0) {
                            keySend.put(p, keySend.get(p) + 1);

                        }

                    }

                }
//              HttpSession s = request.getSession(true);
//              session.setAttribute("allSelectedProducts", keySend);
//                request.getSession().setAttribute("allSelectedProducts", keySend);
                session.setAttribute("allSelectedProducts", keySend);
//              

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
//        System.out.println("ssss");
        HttpSession session = request.getSession(false);

        HashMap<Product, Integer> keySend = (HashMap<Product, Integer>) session.getAttribute("allSelectedProducts");

//        int check = Integer.parseInt(request.getParameter("id"));
        Double price=0.0;

        for (Product p : keySend.keySet()) {
            
            price += p.getProductPrice()*(keySend.get(p));
            
            System.out.println(price);
//            if (p.getId() == check) {
//                if (keySend.get(p) != 0) {
//                    keySend.put(p, keySend.get(p) + 1);
//
//                }

            }
        
        

        
//              HttpSession s = request.getSession(true);
//              session.setAttribute("allSelectedProducts", keySend);
            
if(request.getSession().getAttribute("userInfo")==null)
            {
                request.getRequestDispatcher("login.jsp").include(request,response);
            
            }
            else
            {
                            request.getSession(false).setAttribute("price", price);
                            request.setAttribute("price", price);


                request.getRequestDispatcher("payment.jsp").include(request,response);
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
