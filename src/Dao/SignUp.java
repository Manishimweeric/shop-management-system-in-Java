/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Product;
import Model.SignUpModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author M NJERIC
 */
public class SignUp {
   private static String dburl="jdbc:mysql://localhost:3306/divineshop_management_system_db";
    private static   String username="root";
    private  static  String password="";
    
      
     public String signupregister(SignUpModel pd){
        try {
            Connection con=DriverManager.getConnection(dburl, username, password);
            String sql="Insert into signup(first_name,last_name,address,phone_number,email,password) values(?,?,?,?,?,?)";
            PreparedStatement product=con.prepareStatement(sql);
            product.setString(1, pd.getFirst_name() );
            product.setString(2, pd.getLast_name());
             product.setString(3, pd.getAdderess() );
            product.setString(4, pd.getPhone_number());
             product.setString(5, pd.getEmail() );
            product.setString(6, pd.getPassword());
            int datainsert=product.executeUpdate();
            con.close();
            if(datainsert>=1){
                return"Successdful to SignUp";
                
            }else{
                return" Fail To Create account";
            }  
        } catch (Exception e) {
            e.printStackTrace();
             return "Server Error"+e.getMessage();
        }   
    }
    
     public SignUpModel Searchdata(SignUpModel pd){
         try {
             Connection con=DriverManager.getConnection(dburl, username, password);
            PreparedStatement product=con.prepareStatement("Select * from signup where email=? AND password=?");
             product.setString(1, pd.getEmail());
              product.setString(2, pd.getPassword());
            ResultSet result=product.executeQuery();
             
            if(result.next()){
                SignUpModel thesignup=new SignUpModel();
                thesignup.setManager_id(result.getInt(1));
                thesignup.setFirst_name(result.getString(2));
                thesignup.setLast_name(result.getString(3));
                 thesignup.setAdderess(result.getString(4));
                  thesignup.setPhone_number(result.getString(5));
                   thesignup.setEmail(result.getString(6));
                    thesignup.setPassword(result.getString(7));
                return thesignup;
                 
            }else{
           con.close(); 
             return null;
            }
             
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
}
}