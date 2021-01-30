/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Accessary;
import model.BillAccessary;
import model.Customer;
import model.ImportAccessary;

/**
 *
 * @author Tien Thanh
 */
public class BillAccessaryDAO extends DAO{

    public BillAccessaryDAO() {
    }
    public boolean AddBillAccessary(BillAccessary billAccessary){
        boolean result = false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sql="INSERT INTO tblbillaccessary (total,createdDate) VALUES (?,?);";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, billAccessary.getTotal());
            ps.setString(2, sdf.format(billAccessary.getCreatedDate()));
            ps.execute();
            result=true;
        } catch (SQLException ex) {
            Logger.getLogger(BillAccessaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public int getIdLater(){
        int result=0;
        try {
            String sql="SELECT * FROM qlgara_oto.tblbillaccessary;";
            PreparedStatement ps =con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                result=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillAccessaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public ArrayList<ImportAccessary> searchBill(int id){
       ArrayList<ImportAccessary> list=new ArrayList<>();
       String sql="SELECT * FROM tblimportAccessary WHERE tblBillAccessaryid = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Accessary accessary= new Accessary();
                accessary.setId(rs.getInt(6));
                ImportAccessary importAccessary=new ImportAccessary();
                importAccessary.setAccessary(accessary);
                importAccessary.setId(rs.getInt(1));
                importAccessary.setAmount(rs.getInt(2));
                importAccessary.setPriceImport(rs.getInt(3));
                
                list.add(importAccessary);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return list;
    }
}
