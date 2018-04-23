/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBTables;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TECHNOLOGY CITY
 */
public class DBConnection {

    Connection conn = null;
    String queryString;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pst;

    public void connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {

        }

        try {
            conn
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce project?"
                            + "user=root&password=root");

            // Do something with the Connection
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("can't connect witrh db");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    public User checkUserInfo(String email, String password) {

        try {
            pst = conn.prepareStatement("SELECT * FROM user WHERE Email = '" + email + "' and password = '" + password + "'");

//            pst.setString(0, email);
//            pst.setString(1, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("Email"));
                user.setImg(rs.getString("img"));
                user.setMobile(rs.getString("mobileNum"));
                user.setMoney(rs.getDouble("money"));
                user.setPassword(rs.getString("password"));
                user.setCreditCard(rs.getDouble("creditCard"));
                user.setState(rs.getString("state"));
                user.setId(rs.getInt("id"));

                System.out.println("======================= the user name is " + user.getUserName());
//                conn.close();

                return user;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList getAllProducts() {
        ArrayList<Product> allProducts = new ArrayList<>();

        try {

            pst = conn.prepareStatement("SELECT * FROM product where productQuantity > 0");
//            pst.setString(0, email);
//            pst.setString(1, password);

            rs = pst.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(Integer.valueOf(rs.getString("id")));
                product.setProductCategory(rs.getString("productCategory"));
                product.setProductDesc(rs.getString("productDesc"));
                product.setProductColor(rs.getString("productColor"));
                product.setProductName(rs.getString("productName"));
                product.setProductQuantity(Integer.valueOf(rs.getString("productQuantity")));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setProductImg(rs.getString("productImg"));
                allProducts.add(product);

//                System.out.println("======================= the user name is " + user.getUserName());
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return allProducts;

    }

    public void addUser(String name, String password, String email, String phone, String credit) throws SQLException {

        pst = conn.prepareStatement("insert into user (userName,password,img,Email,state,mobileNum,money,creditCard) values (?,?,?,?,?,?,?,?)");
        pst.setString(1, name);
        pst.setString(2, password);
        pst.setString(3, "/imges/g4.jpg");
        pst.setString(4, email);
        pst.setString(5, "u");
        pst.setString(6, phone);
        pst.setDouble(7, 10000);
        pst.setString(8, credit);

        pst.executeUpdate();

    }

    public int updateUserProfile(String img, int userId) {

        int effectedRows = 0;

        try {
            pst = conn.prepareStatement("update user set img = ? where id = ?");

            pst.setString(1, img);
            pst.setInt(2, userId);

            effectedRows = pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Exception while updating user profile data with error \n");
            ex.printStackTrace();
        }

        return effectedRows;
    }

    public Product getProduct(Character next) {
        Product p = new Product();

        try {

            int c = next - '0';

            pst = conn.prepareStatement("SELECT * FROM product where id=" + c);
            rs = pst.executeQuery();

            while (rs.next()) {
                p.setId(Integer.valueOf(rs.getString("id")));
                p.setProductCategory(rs.getString("productCategory"));
                p.setProductDesc(rs.getString("productDesc"));
                p.setProductColor(rs.getString("productColor"));
                p.setProductName(rs.getString("productName"));
                p.setProductQuantity(Integer.valueOf(rs.getString("productQuantity")));
                p.setProductPrice(rs.getDouble("productPrice"));
                p.setProductImg(rs.getString("productImg"));
                System.out.println(p.getProductName());
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;

    }

    public String checkBeforeBuy(int id, HashMap<Product, Integer> keySend, Double price) {

        System.out.println(id);
        try {
            pst = conn.prepareStatement("SELECT money FROM user where id=" + id);
            rs = pst.executeQuery();

            if (rs.next()) {
                if (rs.getDouble("money") >= price) {
                    for (Product p : keySend.keySet()) {

                        

                        pst = conn.prepareStatement("SELECT productQuantity FROM product where id=? and productQuantity >= ?");
                        
                        
                        pst.setInt(1,id);
                        pst.setInt(2, keySend.get(p));
                        rs = pst.executeQuery();
                        if (!rs.next()) {
                            return "error at product" + p.getProductName();

                        }
                    }

                    return "Done";

                } else {
                    return "No Enough Money";
                }

            }

//            pst.setString(1, img);
//            pst.setInt(2, userId);
//            
//            effectedRows = pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Exception while updating user profile data with error \n");
            ex.printStackTrace();
        }

        return "nos";

    }

    public String buyProducts(int id, HashMap<Product, Integer> keySend, Double price) {

        try {
            pst = conn.prepareStatement("update user set money = money-" + price + " where id =" + id);
            pst.executeUpdate();

            for (Product p : keySend.keySet()) {

                pst = conn.prepareStatement("update product set productQuantity = productQuantity-"
                        + keySend.get(p) + " where id =" + p.getId());
                pst.executeUpdate();

                pst = conn.prepareStatement("insert into user_buy_product  values("+id+","+p.getId()+","
                        +keySend.get(p)+","+p.getProductPrice()*keySend.get(p)+")");
                try{
                
                    pst.executeUpdate();
                }
                catch(Exception e)
                {
                {
                    pst=conn.prepareStatement("update user_buy_product set quentity=quentity+"+keySend.get(p)
                            +" , total_price=total_price+"+p.getProductPrice()*keySend.get(p)+" where user_id = "+id+" and product_id="+p.getId()+" ");
                                        pst.executeUpdate();

                
                }
                    
                }
                
                

            }

        } catch (SQLException ex) {
            System.out.println("Exception while updating user profile data with error \n");
            ex.printStackTrace();
        }

        return "insert & update";

    }
    
    public ArrayList<Product> AllProductsByUser(int id) {
              
        ArrayList<Product> productsArray= new ArrayList<Product>();

                        
        try {
            pst = conn.prepareStatement("SELECT ubp.product_id , p.* FROM user_buy_product ubp , product p where user_id = ? and ubp.product_id = p.id");
            
            pst.setInt(1, id);
            
            rs = pst.executeQuery();

                while (rs.next()) {
                    System.out.println("yes there is next");
                    Product product = new Product();

                    product.setId(Integer.valueOf( rs.getString("id")));
                    product.setProductCategory(rs.getString("productCategory"));
                    product.setProductDesc(rs.getString("productDesc"));
                    product.setProductColor(rs.getString("productColor"));
                    product.setProductName(rs.getString("productName"));
                    product.setProductQuantity(Integer.valueOf(rs.getString("productQuantity")));
                    product.setProductPrice(rs.getDouble("productPrice"));
                    product.setProductImg(rs.getString("productImg"));
                    
                    productsArray.add(product);
                }
                
//                return productsArray;
//            }
         
        } catch (SQLException ex) {
            System.out.println("Exception while updating user profile data with error \n");
            ex.printStackTrace();
        }
        
        return productsArray;
    }

    public int updateUserProfile(User newUserData, String currentUserId) {
        
        int effectedRows = 0;
        String query = "update user set userName = ? ,Email=? , password=? , mobileNum=?  where id ="+currentUserId;
        
        try {
            pst = conn.prepareStatement(query);
            
            System.out.println(newUserData.getUserName());
            
            pst.setString(1, newUserData.getUserName());
            pst.setString(2, newUserData.getEmail());
            pst.setString(3 , newUserData.getPassword());
            pst.setString(4, newUserData.getMobile());
            
            
            effectedRows = pst.executeUpdate();
            System.out.println(effectedRows);
         
        } catch (SQLException ex) {
            System.out.println("Exception while updating user profile data with error \n");
            ex.printStackTrace();
        }
        
        return effectedRows;
    }
    
    
    public User getAllUserData(String userId){
        
        User user = new User();
        System.out.println("in db method to get user with id " + userId);
        
        try {
            
            pst = conn.prepareStatement("SELECT * FROM user where id="+userId);
//            pst.setInt(1, userId);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                System.out.println("yes there is next in get user ");
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("Email"));
                user.setImg(rs.getString("img"));
                user.setMobile(rs.getString("mobileNum"));
                user.setMoney(rs.getDouble("money"));
                user.setPassword(rs.getString("password"));
                user.setCreditCard(rs.getDouble("creditCard"));
                user.setState(rs.getString("state"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        return user;

    }

    
    public int updateUserImage(String img , int userId){
    
        int effectedRows = 0;
        
        try {
            pst = conn.prepareStatement("update user set img = ? where id = ?");
            
            pst.setString(1, img);
            pst.setInt(2, userId);
            
            effectedRows = pst.executeUpdate();
            System.out.println("in userUpdateImage Method in DBConnection class");
         
        } catch (SQLException ex) {
            System.out.println("Exception while updating user profile data with error \n");
            ex.printStackTrace();
        }
        
        return effectedRows;
    }

    public int chargeAccount(int id , double amount) {
        
        int effectedRows = 0;
        String query = "update user set money=money+? where id = ?";
        
        try {
            pst = conn.prepareStatement(query);
            
            pst.setDouble(1, amount);
            pst.setInt(2,id);
            
            
            effectedRows = pst.executeUpdate();
         
        } catch (SQLException ex) {
            System.out.println("Exception while charging use account  \n");
            ex.printStackTrace();
        }
        
        return effectedRows;

    }

    public ArrayList getAllProductsAdmin() {
    ArrayList<Product> allProducts = new ArrayList<>();

        try {

            pst = conn.prepareStatement("SELECT * FROM product where productQuantity ");
//            pst.setString(0, email);
//            pst.setString(1, password);

            rs = pst.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(Integer.valueOf(rs.getString("id")));
                product.setProductCategory(rs.getString("productCategory"));
                product.setProductDesc(rs.getString("productDesc"));
                product.setProductColor(rs.getString("productColor"));
                product.setProductName(rs.getString("productName"));
                product.setProductQuantity(Integer.valueOf(rs.getString("productQuantity")));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setProductImg(rs.getString("productImg"));
                allProducts.add(product);

//                System.out.println("======================= the user name is " + user.getUserName());
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return allProducts;

    
    }

    public String deleteProduct(String id) {
        int e = 0;
            
        try {
            
            pst = conn.prepareStatement("delete from product where id ="+id);
            e=pst.executeUpdate();
            if(e==1)
          return "Done";
            else
                return "Can't delete this product";
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Can't delete this product";

    }

    public String updateProduct(String id, String name, String cat, String quentity, String color
            , String desc, String price) {
        
        int effectedRows = 0;
        String res="";
        
        try {
            pst = conn.prepareStatement("update product set productName='"+name+"' ,productCategory='"+cat+"' "
                    + ",productColor='"+color+"' ,productDesc='"+desc+"' ,productPrice="+price+" "
                            + ",productQuantity="+quentity+" where id="+id);
            
            
            
            effectedRows = pst.executeUpdate();
            if(effectedRows!=0)
            {
                res="Done";
            }
            
            System.out.println("in userUpdateImage Method in DBConnection class");
         
        } catch (SQLException ex) {
            System.out.println("Exception while updating user profile data with error \n");
            ex.printStackTrace();
        }
        
        return res;
        
        

        
    }

    public String AddProduct(String id, String name, String cat, String quentity, String color
            , String desc, String price) {
        
        int effectedRows = 0;
        String res="";
        
        try {
            pst = conn.prepareStatement("insert into product (product.productName,product.productPrice,product.productQuantity,product.productDesc,"
                    + " product.productCategory, product.productColor)"
                    + " values('"+name+"',"+price+","+quentity+",'"+desc+"','"+cat+"','"+color+"')");
            
            
            
            effectedRows = pst.executeUpdate();
            if(effectedRows!=0)
            {
                res="Done";
            }
            
            System.out.println("in userUpdateImage Method in DBConnection class");
         
        } catch (SQLException ex) {
            System.out.println("Exception while updating user profile data with error \n");
            ex.printStackTrace();
        }
        
        return res;
        
        


    }

    public ArrayList getAllUsersAdmin(String id ) {
        
        ArrayList<User> allusers = new ArrayList<>();

        try {

            pst = conn.prepareStatement("select * from user where id <> "+id);
//            pst.setString(0, email);
//            pst.setString(1, password);

            rs = pst.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("Email"));
                user.setImg(rs.getString("img"));
                user.setMobile(rs.getString("mobileNum"));
                user.setMoney(rs.getDouble("money"));
                user.setPassword(rs.getString("password"));
                user.setCreditCard(rs.getDouble("creditCard"));
                user.setState(rs.getString("state"));
                user.setId(rs.getInt("id"));
                
                allusers.add(user);

//                System.out.println("======================= the user name is " + user.getUserName());
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return allusers;
        

    }

//    
//    request.getParameter("id"),
//                    request.getParameter("userName"),request.getParameter("password"),
//                    request.getParameter("email"),request.getParameter("state"),
//                    request.getParameter("mobile"),request.getParameter("money")
//                    ,request.getParameter("creditCard"),request.getParameter("img"));
//    
    public String updateUser(String id, String userName,
            String password, String email, String state,
            String mobile, String money, String creditCard,
            String img) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        int effectedRows = 0;
        String res="";
        
        try {
            pst = conn.prepareStatement("update user set userName='"+userName+"',"
                    + " password="+password+" , img='"+img+"',Email='"+email+"',state='"+state+"',"
                    + "mobileNum="+mobile+",money="+money+",creditCard="+creditCard+" where id="+id);
            
            
            
            effectedRows = pst.executeUpdate();
            if(effectedRows!=0)
            {
                res="Done";
            }
            
            System.out.println("in userUpdateImage Method in DBConnection class");
         
        } catch (SQLException ex) {
            System.out.println("Exception while updating user profile data with error \n");
            ex.printStackTrace();
        }
        
        return res;

    }

    public String deleteUser(String id) {
        try {
            int e=0;

                   pst = conn.prepareStatement("delete from user where id ="+id);
                   e=pst.executeUpdate();

                   if(e==1)
                 return "Done";

                   else
                       return "Can't delete this product"; 
                       
               } catch (SQLException ex) {
                   Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
               }

               return "Can't delete this product";    
    }

   


    public String AddUser(String id, String userName,
            String password, String email, String state,
            String mobile, String money, String creditCard,
            String img) {
        
        try {
            pst = conn.prepareStatement("insert into user (userName,password,img,Email,state,mobileNum,money,creditCard) values (?,?,?,?,?,?,?,?)");
            pst.setString(1, userName);
            pst.setString(2, password);
            pst.setString(3, "images//calender1521151160223.png");
            pst.setString(4, email);
            pst.setString(5, "u");
            pst.setString(6, mobile);
            pst.setDouble(7, 10000);
            pst.setString(8, creditCard);
            
            pst.executeUpdate();
            
            return "Done inserting user by Admin";
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Can't insert user by Admin";

    }
    
    
        public int updateUserProfileData(User newUserData, int currentUserId) {
        
        int effectedRows = 0;
        String query = "update user set userName = ? ,Email=? , password=? , mobileNum=? , img=?  where id = ?";
        
        try {
            pst = conn.prepareStatement(query);
            
            pst.setString(1, newUserData.getUserName());
            pst.setString(2, newUserData.getEmail());
            pst.setString(3 , newUserData.getPassword());
            pst.setString(4, newUserData.getMobile());
            pst.setString(5, newUserData.getImg());
            pst.setInt(6, currentUserId);
            
            effectedRows = pst.executeUpdate();
            
            System.out.println("number of effected rows in dbConnection updateUserInfo are" + effectedRows);
         
        } catch (SQLException ex) {
            System.out.println("Exception while updating user profile data with error \n");
            ex.printStackTrace();
        }
        
        return effectedRows;
    }
        
        
            public Product getProductById(String id) {
        Product p = new Product();

        try {

            pst = conn.prepareStatement("SELECT * FROM product where id=" + id);
            rs = pst.executeQuery();

            while (rs.next()) {
                p.setId(Integer.valueOf(rs.getString("id")));
                p.setProductCategory(rs.getString("productCategory"));
                p.setProductDesc(rs.getString("productDesc"));
                p.setProductColor(rs.getString("productColor"));
                p.setProductName(rs.getString("productName"));
                p.setProductQuantity(Integer.valueOf(rs.getString("productQuantity")));
                p.setProductPrice(rs.getDouble("productPrice"));
                p.setProductImg(rs.getString("productImg"));
                System.out.println(p.getProductName());
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;

    }

}
