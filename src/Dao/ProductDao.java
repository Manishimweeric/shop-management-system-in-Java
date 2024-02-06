/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Product;
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
public class ProductDao {
    
    private static String dburl="jdbc:mysql://localhost:3306/divineshop_management_system_db";
    private static   String username="root";
    private  static  String password="";
    
    
    
    public String Registerproduct(Product pd){
        try {
            Connection con=DriverManager.getConnection(dburl, username, password);
            String sql="Insert into product values(?,?,?,?,?)";
            PreparedStatement product=con.prepareStatement(sql);
            product.setString(1, pd.getProduct_id());
            product.setString(2, pd.getProduct_name());
            product.setInt(3, pd.getQuantity());
            product.setInt(4, pd.getPriceperItem());
            product.setString(5, pd.getDatecames());
               
            int datainsert=product.executeUpdate();
            con.close();
            if(datainsert>=1){
                return"Successdful To Register Product";
                
            }else{
                return"Registered product Fail";
            }  
        } catch (Exception e) {
            e.printStackTrace();
             return "Server Error"+e.getMessage();
        }   
    }
    
    /*     
     Update Product
    */
    
        public String Updateproduct(Product pd){
        try {
            Connection con=DriverManager.getConnection(dburl, username, password);
            String sql="Update product set product_name=?,Quantity=?,priceperitem=?,Date=? where product_id=?";
            PreparedStatement product=con.prepareStatement(sql);
            product.setString(5, pd.getProduct_id());
            product.setString(1, pd.getProduct_name());
            product.setInt(2, pd.getQuantity());
            product.setInt(3, pd.getPriceperItem());
            product.setString(4, pd.getDatecames());
            int datainsert=product.executeUpdate();
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
        public String Updateproductfromcustomer(Product pd){
        try {
            Connection con=DriverManager.getConnection(dburl, username, password);
            String sql="Update product set Quantity=? where product_id=?";
            PreparedStatement product=con.prepareStatement(sql); 
            product.setInt(1, pd.getQuantity());
            product.setString(2, pd.getProduct_id());
            int datainsert=product.executeUpdate();
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
        
        
        
        
     public String Deleteproduct(Product pd){
        try {
            Connection con=DriverManager.getConnection(dburl, username, password);
            String sql="Delete from product where product_id=? ";
            PreparedStatement product=con.prepareStatement(sql);
            product.setString(1, pd.getProduct_id());
            int datainsert=product.executeUpdate();
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
     
      public List<Product> displayproductdata(){
         try {
             Connection con=DriverManager.getConnection(dburl, username, password);
            PreparedStatement product=con.prepareStatement("Select * from product");
            ResultSet result=product.executeQuery();
            List<Product> productList= new ArrayList<>();
            boolean condition=false;
            while(result.next()){
                Product theproduct=new Product();
                theproduct.setProduct_id(result.getString(1));
                theproduct.setProduct_name(result.getString(2));
                theproduct.setQuantity(result.getInt(3));
                theproduct.setPriceperItem(result.getInt(4));
                theproduct.setDatecames(result.getString(5));
                productList.add(theproduct);
                condition=true;
            }
            con.close();
            if(condition==true){
                return productList; 
            }else{
             return null;
         }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
          
    }
      
      public Product Searchdata(Product pd){
         try {
             Connection con=DriverManager.getConnection(dburl, username, password);
            PreparedStatement product=con.prepareStatement("Select * from product where product_id=?");
             product.setString(1, pd.getProduct_id());
            ResultSet result=product.executeQuery();
                
            if(result.next()){
                Product theproduct=new Product();
                theproduct.setProduct_id(result.getString(1));
                theproduct.setProduct_name(result.getString(2));
                theproduct.setQuantity(result.getInt(3));
                theproduct.setPriceperItem(result.getInt(4));
                theproduct.setDatecames(result.getString(5));
                return theproduct;
            }
            
           con.close();
             return null;
         
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
          
    }
      
      public Product Searchdatabyname(Product pd){
         try {
             Connection con=DriverManager.getConnection(dburl, username, password);
            PreparedStatement product=con.prepareStatement("Select * from product where product_name=?");
             product.setString(1, pd.getProduct_name());
            ResultSet result=product.executeQuery();
                
            if(result.next()){
                Product theproduct=new Product();
                theproduct.setProduct_id(result.getString(1));
                theproduct.setProduct_name(result.getString(2));
                theproduct.setQuantity(result.getInt(3));
                theproduct.setPriceperItem(result.getInt(4));
                theproduct.setDatecames(result.getString(5));
                return theproduct;
            }
            
           con.close();
             return null;
         
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
          
    }
}
