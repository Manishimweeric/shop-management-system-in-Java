/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author M NJERIC
 */
public class Product {
    
    private String product_id;
    private String product_name;
    private  Integer Quantity;
    private Integer priceperItem;
    private String Datecames;

    public Product() {
    }

    public Product(String product_id, String product_name, Integer Quantity, Integer priceperItem, String Datecames) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.Quantity = Quantity;
        this.priceperItem = priceperItem;
        this.Datecames = Datecames;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public Integer getPriceperItem() {
        return priceperItem;
    }

    public void setPriceperItem(Integer priceperItem) {
        this.priceperItem = priceperItem;
    }

    public String getDatecames() {
        return Datecames;
    }

    public void setDatecames(String Datecames) {
        this.Datecames = Datecames;
    }
    
    
}
