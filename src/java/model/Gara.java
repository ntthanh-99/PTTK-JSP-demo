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
public class Gara extends AbstractEntity{
    private int id;
    private String name;
    private String address;
    private String email;
    private String phone;

    public Gara() {
    }

    public Gara(int id, String name, String address, String email,
    String phone, Date createdDate, Date modifiedDate) {
        super(createdDate, modifiedDate);
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
