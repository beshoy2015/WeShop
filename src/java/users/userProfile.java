/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import DBTables.DBConnection;
import DBTables.Product;
import DBTables.User;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;




/**
 *
 * @author Salma
 */
public class userProfile extends HttpServlet {
    
    String savePath;
    String uploadedImgProfileName;
    DBConnection dBConnection;
    String uniqueImgFileName;
    

    public userProfile() {
        
        dBConnection = new DBConnection();
        dBConnection.connect();
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        System.out.println("in doGet Method in [userProfile servlet]");
        //get products which bought by a specific user
        User user = (User) request.getSession().getAttribute("userInfo"); //loggedIn user
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        
        ArrayList<Product> productsByUser = dBConnection.AllProductsByUser(user.getId());

        Gson AllproductsbyUser = new Gson();
        out.write(AllproductsbyUser.toJson(productsByUser));
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        PrintWriter out = response.getWriter();
        User currentUser = (User) request.getSession().getAttribute("userInfo");
//        User newUserData = new User();
//        newUserData.setId(currentUser.getId());

        
        System.out.println("current user id is" + currentUser.getId() + "his email" + currentUser.getEmail() + "his img" + currentUser.getImg());
//        System.out.println("new user id is" + newUserData.getId() + "his email" + newUserData.getEmail() + "his img" + newUserData.getImg());


        if(request.getParameterMap().containsKey("emailField"))
        {
            
            System.out.println("3) in update user info if condition in server");
        
            currentUser.setEmail(request.getParameter("emailField"));
            currentUser.setUserName(request.getParameter("userNameField"));
            currentUser.setMobile(request.getParameter("phoneField"));
            currentUser.setPassword(request.getParameter("passwordField"));
            currentUser.setImg(request.getParameter("img"));
            
            String res = updateUserInfoInDB(currentUser , currentUser.getId());
            
            if(res.equals("Done"))
            {
                
                request.getSession(false).setAttribute("userInfo", currentUser);
                out.print("Done");
            }else{
                out.print("error");
            }
            
        }else if(request.getParameterMap().containsKey("keyNumber")){
            
            String keyNumberVal = request.getParameter("keyNumber");
        
            int effectedRows = 0;
            
            if(keyNumberVal.equals("123456")){
                effectedRows = dBConnection.chargeAccount(currentUser.getId() , 1000);
                currentUser.setMoney(currentUser.getMoney()+1000);
            }
            else if(keyNumberVal.equals("654321")){
                effectedRows = dBConnection.chargeAccount(currentUser.getId() , 2000);
                currentUser.setMoney(currentUser.getMoney()+2000);
            }
            else if (keyNumberVal.equals("135792")){
                effectedRows = dBConnection.chargeAccount(currentUser.getId() , 3000);
                currentUser.setMoney(currentUser.getMoney()+3000);
            }
            
            
            if(effectedRows == 1)
            {
                request.getSession(false).setAttribute("userInfo", currentUser);
                out.print("Done");
            }
                
        
        }else{
            System.out.println("in second if in servlet");
            uploadedImgProfileName = saveImageInServer(request , response);
         
            if(!uploadedImgProfileName.equals(null))
            {
                saveUploadedImageInDB(uploadedImgProfileName , request , response);
                currentUser.setImg(uploadedImgProfileName);
                request.getSession(false).setAttribute("userInfo", currentUser);
                out.print(uploadedImgProfileName);
            }
            else
                System.out.println("something wrong happened when saving img on server ");
        
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

    private String saveImageInServer(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException{

        try {
            
            PrintWriter out = response.getWriter();
            
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();
            
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            // Parse the request
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                System.out.println("Entered while loop ==>");
                FileItem item = iter.next();
                if (item.isFormField()) {
                   
                    String name = item.getFieldName();
                    String value = item.getString();
                } else {
                    System.out.println("in else case");
                    if (!item.isFormField()) {
                        try {
                            String fileNameWithoutExtention = item.getName().substring(0 , item.getName().lastIndexOf("."));
                            String extention = item.getName().substring(item.getName().lastIndexOf("."));
                            uniqueImgFileName =  fileNameWithoutExtention + new Date().getTime() + extention;
                            savePath = getServletContext().getRealPath("")+ "\\"+ "images";
                            item.write(new File(savePath + File.separator + uniqueImgFileName));
                            return "images//"+uniqueImgFileName;
                            
                        } catch (Exception ex) {
                            ex.printStackTrace();
                  
                        }
                    }
                }
            }
        } catch (FileUploadException ex) {
            System.out.println("Exception while saving uploaded image in catch section with error \n");
            ex.printStackTrace();
        }
//    
        return null;
    
    }

    private void saveUploadedImageInDB(String uploadedImage , HttpServletRequest request, HttpServletResponse response) {
        
        //get current user from session 
        User user = (User) request.getSession().getAttribute("userInfo");
        
        //update current user data in db using his ID
        int effectedRows = dBConnection.updateUserImage(uploadedImage , user.getId());
        System.out.println("the user id is " + user.getUserName());
        
        if(effectedRows != 0)
            System.out.println("image updated successfully with no of effected rows " + effectedRows);
        else
            System.out.println("something wrong happened while updating user image [in userProfile servlet]");
    }

    private String updateUserInfoInDB(User newUserData , int currentUserId) {
        
        //update current user data in db using his ID
        int effectedRows = 0;
        try{
        effectedRows = dBConnection.updateUserProfileData(newUserData , currentUserId);
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        if(effectedRows == 1)
        {
            System.out.println("data updated successfully with no of effected rows " + effectedRows);
            return "Done";
        }
        else{
            System.out.println("something wrong happened while updating user info [in userProfile servlet] number of effected rows are" + effectedRows);
            return "Error";
        }
    }
}
