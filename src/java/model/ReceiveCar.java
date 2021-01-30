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
public class ReceiveCar extends AbstractEntity{
    private int id;
    private String description;
    private int IsPayed;
    private TechnicalStaff technicalStaff;
    private Customer customer;
    

    public ReceiveCar() {
    }

    public ReceiveCar(int id, String description, int IsPayed, TechnicalStaff technicalStaff, Customer customer, Date createdDate, Date modifiedDate) {
        super(createdDate, modifiedDate);
        this.id = id;
        this.description = description;
        this.IsPayed = IsPayed;
        this.technicalStaff = technicalStaff;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int isIsPayed() {
        return IsPayed;
    }

    public void setIsPayed(int IsPayed) {
        this.IsPayed = IsPayed;
    }

    public TechnicalStaff getTechnicalStaff() {
        return technicalStaff;
    }

    public void setTechnicalStaff(TechnicalStaff technicalStaff) {
        this.technicalStaff = technicalStaff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
