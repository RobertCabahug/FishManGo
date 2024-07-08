package com.example.fishmango.sysarch.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

    @Id
    private int prod_id;
    private String name;
    private String price;
    private String status;

    public Product(){

    }

    public void setId(int prod_id) {
        this.prod_id = prod_id;
    }
    public int getId() {
        return prod_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getname() {
        return name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getPrice() {
        return price;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}



