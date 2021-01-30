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
public class BillAccessary extends AbstractEntity{
    private int id;
    private int total;
    private Employee employee;

    public BillAccessary() {
    }

    public BillAccessary(int id, int total, Employee employee, Date createdDate, Date modifiedDate) {
        super(createdDate, modifiedDate);
        this.id = id;
        this.total = total;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    
}
