/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import DBTables.DBConnection;
import DBTables.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Salma
 */
public class getUserProfileByAdmin extends HttpServlet {

    DBConnection dbConnection;
    
    public getUserProfileByAdmin() {
        dbConnection = new DBConnection(); 
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        System.out.println("the selected user by admin is " + Integer.parseInt(request.getParameter("userId")));
        User user = dbConnection.getAllUserData(request.getParameter("userId"));
        request.setAttribute("selectedUser", user);
        request.getRequestDispatcher("profile.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
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
