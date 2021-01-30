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
public class CustomerStat extends Customer{
    private int total;

    public CustomerStat() {
    }

    public CustomerStat(int total, int id, String name, String address, String email, String phone, Date createdDate, Date modifiedDate) {
        super(id, name, address, email, phone, createdDate, modifiedDate);
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
