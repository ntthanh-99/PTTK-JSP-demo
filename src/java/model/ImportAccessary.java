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
public class ImportAccessary extends AbstractEntity{
    private int id;
    private int amount;
    private int priceImport;
    private Accessary accessary;
    private Supplier supplier;
    private BillAccessary billAccessary;

    public BillAccessary getBillAccessary() {
        return billAccessary;
    }

    public void setBillAccessary(BillAccessary billAccessary) {
        this.billAccessary = billAccessary;
    }

   

    public ImportAccessary() {
    }

    public ImportAccessary(int id, int amount, int priceImport,
    Accessary accessary, Supplier supplier, Date createdDate, Date modifiedDate) {
        super(createdDate, modifiedDate);
        this.id = id;
        this.amount = amount;
        this.priceImport = priceImport;
        this.accessary = accessary;
        this.supplier = supplier;
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

    public int getPriceImport() {
        return priceImport;
    }

    public void setPriceImport(int priceImport) {
        this.priceImport = priceImport;
    }

    public Accessary getAccessary() {
        return accessary;
    }

    public void setAccessary(Accessary accessary) {
        this.accessary = accessary;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
}
