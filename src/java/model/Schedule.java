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
public class Schedule extends AbstractEntity{
    private int id;
    private Customer customer;
    private Employee employee;

    public Schedule() {
    }

    public Schedule(Customer customer, Employee employee, Date createdDate, Date modifiedDate) {
        super(createdDate, modifiedDate);
        this.customer = customer;
        this.employee = employee;
    }
    
}
