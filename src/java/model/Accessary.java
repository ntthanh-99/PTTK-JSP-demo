/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Tien Thanh
 */
public class Accessary extends AbstractEntity{
    private int id;
    private String img;
    private String name;
    private String description;
    private int remainAmount;
    private int price;

    public Accessary() {
    }

    public Accessary(int id, String name, String description, int remainAmount,
       int price, Date createdDate, Date modifiedDate) {
        super(createdDate, modifiedDate);
        this.id = id;
        this.name = name;
        this.description = description;
        this.remainAmount = remainAmount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(int remainAmount) {
        this.remainAmount = remainAmount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
