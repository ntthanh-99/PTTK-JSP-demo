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
public class AccessaryUsed extends AbstractEntity{
    private int id;
    private int amount;
    private int saleoff;
    private int price;
    private Accessary accessary;
    private ReceiveCar receiveCar;

    public AccessaryUsed() {
    }

    public AccessaryUsed(int id, int amount, int saleoff, int price, Accessary accessary, ReceiveCar receiveCar, Date createdDate, Date modifiedDate) {
        super(createdDate, modifiedDate);
        this.id = id;
        this.amount = amount;
        this.saleoff = saleoff;
        this.price = price;
        this.accessary = accessary;
        this.receiveCar = receiveCar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSaleoff() {
        return saleoff;
    }

    public void setSaleoff(int saleoff) {
        this.saleoff = saleoff;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Accessary getAccessary() {
        return accessary;
    }

    public void setAccessary(Accessary accessary) {
        this.accessary = accessary;
    }

    public ReceiveCar getReceiveCar() {
        return receiveCar;
    }

    public void setReceiveCar(ReceiveCar receiveCar) {
        this.receiveCar = receiveCar;
    }
    
}
