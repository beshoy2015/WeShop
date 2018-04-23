/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import DBTables.DBConnection;
import DBTables.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static products.ManageProducts.checkObj;

/**
 *
 * @author TECHNOLOGY CITY
 */
public class AddToCart extends HttpServlet {

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
            HttpSession sessionCheck = request.getSession(false);

            
                Product p = new Product();

                DBConnection dBConnection;
                dBConnection = new DBConnection();
                dBConnection.connect();

                Cookie cookie = null;
                Cookie[] cookies = null;

                // Get an array of Cookies associated with this domain
                cookies = request.getCookies();

                ArrayList<Character> keys = new ArrayList<>();
                HashMap<Character, Integer> keyValue = new HashMap<>();
                HashMap<Product, Integer> keySend = new HashMap<>();

                char element;

                if (cookies != null) {

                    for (int i = 0; i < cookies.length; i++) {
                        cookie = cookies[i];
                        if (cookie.getName().equals("moustafa")) {

                            
                            for (int j = 0; j < cookie.getValue().length(); j++) {

                                char h = cookie.getValue().charAt(j);
                                if (h != '+') {
                                    keys.add(h);
                                }
                            }

                            for (int j = 0; j < keys.size(); j++) {
                                int counter = 0;
                                element = keys.get(j);
                                for (int k = 0; k < keys.size(); k++) {
                                    if (element == keys.get(k)) {
                                        counter++;
                                    }
                                    keyValue.put(element, counter);
                                }
                            }

                            // we check 
                            Set names = keyValue.keySet();

                            Iterator it = names.iterator();

                            while (it.hasNext()) {
                                Character next = (Character) it.next();

                                p = dBConnection.getProduct(next);
                                keySend.put(p, keyValue.get(next));
                            }
                            if (keySend != null) {
                                HttpSession session = request.getSession(true);
                                session.setAttribute("allSelectedProducts", keySend);
                                
                                request.setAttribute("all", keySend);
//                                cookie.setValue("");
//                                ArrayList<Product> pro = (ArrayList<Product>) keySend.keySet();
//                                for (int j = 0; j < keySend.size(); j++) {
//
//                                cookie.getValue().concat(pro.get(j).getId()+"+");
//                            }
//                                
                                
                                
                                request.getRequestDispatcher("checkout.jsp").include(request, response);
                            }

                        }
                       

                    }
                } else {
                    request.getRequestDispatcher("404.jsp").include(request, response);
                }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
