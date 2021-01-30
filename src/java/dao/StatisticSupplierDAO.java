/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BillAccessary;
import model.SupplierStat;

/**
 *
 * @author Tien Thanh
 */
public class StatisticSupplierDAO extends DAO{

    public StatisticSupplierDAO() {
    }
    public ArrayList<SupplierStat> StatSupplier(Date start,Date end){
        ArrayList<SupplierStat> listSupplierStats = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            
            String sql ="select s.*,i.amount,i.priceImport from tblsupplier s inner join tblimportaccessary i on i.tblSupplierid=s.id where i.createdDate>? and i.createdDate<?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, sdf.format(start));
            ps.setString(2, sdf.format(end));
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                SupplierStat supplierStat = new SupplierStat();
                supplierStat.setId(rs.getInt(1));
                supplierStat.setName(rs.getString(2));
                supplierStat.setDescription(rs.getString(3));
                supplierStat.setAddress(rs.getString(4));
                supplierStat.setPhone(rs.getString(5));
                supplierStat.setAmount(rs.getInt(8));
                int importPrice=rs.getInt(9);
                int income=importPrice*supplierStat.getAmount();
                supplierStat.setIncome(income);
                listSupplierStats.add(supplierStat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSupplierStats;
    }
    public ArrayList<BillAccessary> DetailSupplier(SupplierStat supplierStat) throws ParseException{
        ArrayList<BillAccessary> listBillAccessarys=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String sql="select b.* from tblsupplier s inner join tblimportaccessary i on i.tblSupplierid=s.id inner join tblbillaccessary b on b.id=i.tblBillAccessaryid where s.id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, supplierStat.getId());
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                BillAccessary billAccessary=new BillAccessary();
                billAccessary.setId(rs.getInt(1));
                billAccessary.setTotal(rs.getInt(2));
                billAccessary.setCreatedDate(sdf.parse(rs.getString(3)));
                listBillAccessarys.add(billAccessary);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBillAccessarys;
    }
}
