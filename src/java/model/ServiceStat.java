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
public class ServiceStat extends Service{
    private int amount;
    private int income;

    public ServiceStat() {
    }

    public ServiceStat(int amount, int income, int id, String name, String description, int price, Date createdDate, Date modifiedDate) {
        super(id, name, description, price, createdDate, modifiedDate);
        this.amount = amount;
        this.income = income;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
    
}
