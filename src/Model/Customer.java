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
public class Customer {
    private Integer service_Id;
    private String customer_name;
    private String product_name;
    private Integer quantity;
    private Integer totalprice;
    private String Date;

    public Customer() {
    }

    public Customer(Integer service_Id, String customer_name, String product_name, Integer quantity, Integer totalprice, String Date) {
        this.service_Id = service_Id;
        this.customer_name = customer_name;
        this.product_name = product_name;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.Date = Date;
    }

    public Integer getService_Id() {
        return service_Id;
    }

    public void setService_Id(Integer service_Id) {
        this.service_Id = service_Id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
    
    
}
