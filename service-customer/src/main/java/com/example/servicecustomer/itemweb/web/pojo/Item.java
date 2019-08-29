package com.example.servicecustomer.itemweb.web.pojo;

import java.io.Serializable;

public class Item implements Serializable {

    private Long id;
    private String name;
    private float price;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}