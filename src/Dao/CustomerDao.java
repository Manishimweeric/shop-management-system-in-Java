/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author M NJERIC
 */
public class CustomerDao {
     private static String dburl="jdbc:mysql://localhost:3306/divineshop_management_system_db";
    private static   String username="root";
    private  static  String password="";
    
    
    
    public String Registercustomer(Customer pd){
        try {
            Connection con=DriverManager.getConnection(dburl, username, password);
            String sql="Insert into customer(customer_name,product_name,quantity,totalprice,Date) values(?,?,?,?,?)";
            PreparedStatement customer=con.prepareStatement(sql);
            customer.setString(1, pd.getCustomer_name());
            customer.setString(2, pd.getProduct_name());
            customer.setInt(3, pd.getQuantity());
            customer.setInt(4, pd.getTotalprice());
            customer.setString(5, pd.getDate());
               
            int datainsert=customer.executeUpdate();
            con.close();
            if(datainsert>=1){
                return"Successdful To Register Customer";
                
            }else{
                return"Registered customer Fail";
            }  
        } catch (Exception e) {
            e.printStackTrace();
             return "Server Error"+e.getMessage();
        }   
    }
    
    /*     
     Update Customer
    */
    
        public String Updatecustomer(Customer pd){
        try {
            Connection con=DriverManager.getConnection(dburl, username, password);
            String sql="Update customer set customer_name=?,Quantity=?,totalprice=?,Date=? where customer_id=?";
            PreparedStatement customer=con.prepareStatement(sql);
            customer.setString(1, pd.getCustomer_name());
            customer.setInt(2, pd.getQuantity());
            customer.setInt(3, pd.getTotalprice());
            customer.setString(4, pd.getDate());
            customer.setInt(5, pd.getService_Id());
            int datainsert=customer.executeUpdate();
            con.close();
            if(datainsert>=1){
                return"Update Successdful ";
                
            }else{
                return"Fail to Update";
            }  
        } catch (Exception e) {
            e.printStackTrace();
             return "Server Error"+e.getMessage();
        }   
    }
        
        
        
        
     public String Deletecustomer(Customer pd){
        try {
            Connection con=DriverManager.getConnection(dburl, username, password);
            String sql="Delete from customer where customer_id=? ";
            PreparedStatement customer=con.prepareStatement(sql);
            customer.setInt(1, pd.getService_Id());
            int datainsert=customer.executeUpdate();
            con.close();
            if(datainsert>=1){
                return"Data Deleted Successful";
                
            }else{
                return"Fail To delete data";
            }  
        } catch (Exception e) {
            e.printStackTrace();
             return "Server Error"+e.getMessage();
        }   
    }
     
      public List<Customer> displaycustomerdata(){
         try {
             Connection con=DriverManager.getConnection(dburl, username, password);
            PreparedStatement customer=con.prepareStatement("Select * from customer");
            ResultSet result=customer.executeQuery();
            List<Customer> customerList= new ArrayList<>();
            boolean condition=false;
            while(result.next()){
                Customer thecustomer=new Customer();
                thecustomer.setService_Id(result.getInt(1));
                thecustomer.setCustomer_name(result.getString(2));
                thecustomer.setProduct_name(result.getString(3));
                thecustomer.setQuantity(result.getInt(4));
                thecustomer.setTotalprice(result.getInt(5));
                thecustomer.setDate(result.getString(6));
                customerList.add(thecustomer);
                condition=true;
            }
            con.close();
            if(condition==true){
                return customerList; 
            }else{
             return null;
         }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
          
    }
      
      public Customer Searchdata(Customer pd){
         try {
             Connection con=DriverManager.getConnection(dburl, username, password);
            PreparedStatement customer=con.prepareStatement("Select * from customer where customer_id=?");
             customer.setInt(1, pd.getService_Id());
            ResultSet result=customer.executeQuery();
                
            if(result.next()){
                Customer thecustomer=new Customer();
                thecustomer.setService_Id(result.getInt(1));
                thecustomer.setCustomer_name(result.getString(2));
                thecustomer.setProduct_name(result.getString(3));
                thecustomer.setQuantity(result.getInt(4));
                thecustomer.setTotalprice(result.getInt(5));
                thecustomer.setDate(result.getString(6));
                return thecustomer;
            }
            
           con.close();
             return null;
         
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
          
    }
}
