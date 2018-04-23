/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TECHNOLOGY CITY
 */
public class UpdateUserData extends HttpServlet {

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
           
//            <input type="hidden" name="id" value="${sessionScope.allUsers[i].id}"/>
//                                                    <input type="hidden" name="userName" value="${sessionScope.allUsers[i].userName}"/>
//                                                    <input type="hidden" name="password" value="${sessionScope.allUsers[i].password}"/>
//                                                    <input type="hidden" name="img" value="${sessionScope.allUsers[i].img}"/>
//                                                    <input type="hidden" name="email" value="${sessionScope.allUsers[i].email}"/>
//                                                    <input type="hidden" name="state" value="${sessionScope.allUsers[i].state}"/>
//                                                    <input type="hidden" name="mobile" value="${sessionScope.allUsers[i].mobile}"/>
//                                                    <input type="hidden" name="money" value="${sessionScope.allUsers[i].money}"/>
//                                                    <input type="hidden" name="creditCard"
            
            
            request.setAttribute("img",request.getParameter("img"));
            request.setAttribute("id",request.getParameter("id"));
            request.setAttribute("userName",request.getParameter("userName"));
            request.setAttribute("password",request.getParameter("password"));
            request.setAttribute("email",request.getParameter("email"));
            request.setAttribute("state",request.getParameter("state"));
            request.setAttribute("mobile",request.getParameter("mobile"));
            request.setAttribute("money",request.getParameter("money"));
            request.setAttribute("creditCard",request.getParameter("creditCard"));

//            request.setAttribute("quentity", );
            request.getRequestDispatcher("UpdateUser.jsp").include(request, response);
            
            
            
            
            
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
