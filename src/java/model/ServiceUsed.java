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
public class ServiceUsed extends AbstractEntity{
    private int id;
    private int amount;
    private int saleoff;
    private int price;
    private Service service;
    private ReceiveCar receiveCar;

    public ServiceUsed() {
    }

    public ServiceUsed(int id, int amount, int saleoff, int price, Service service, ReceiveCar receiveCar, Date createdDate, Date modifiedDate) {
        super(createdDate, modifiedDate);
        this.id = id;
        this.amount = amount;
        this.saleoff = saleoff;
        this.price = price;
        this.service = service;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ReceiveCar getReceiveCar() {
        return receiveCar;
    }

    public void setReceiveCar(ReceiveCar receiveCar) {
        this.receiveCar = receiveCar;
    }
    
}
