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
public class AccessaryStat extends Accessary{
    private int amount;
    private int income;

    public AccessaryStat() {
    }

    public AccessaryStat(int income, int id, String name, String description, int remainAmount, int price, Date createdDate, Date modifiedDate) {
        super(id, name, description, remainAmount, price, createdDate, modifiedDate);
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
