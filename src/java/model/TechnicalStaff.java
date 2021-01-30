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
public class TechnicalStaff extends AbstractEntity{
    private int id;
    private String name;
    private String address;
    private String phone;
    private boolean isBusy;

    public TechnicalStaff() {
    }

    public TechnicalStaff(int id, String name, String address, String phone, boolean isBusy, Date createdDate, Date modifiedDate) {
        super(createdDate, modifiedDate);
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isBusy = isBusy;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIsBusy() {
        return isBusy;
    }

    public void setIsBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }
    
}
