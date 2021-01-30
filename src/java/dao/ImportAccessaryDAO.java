/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Accessary;
import model.ImportAccessary;

/**
 *
 * @author Tien Thanh
 */
public class ImportAccessaryDAO {

    public ImportAccessaryDAO() {
    }
    public boolean addImportAccessary(ImportAccessary importAccessary){
         boolean result = false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sql="INSERT INTO tblimportaccessary (amount,priceImport,createdDate,tblAccessaryid,tblSupplierid,tblBillAccessaryid) VALUES (?,?,?,?,?,?);";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, importAccessary.getAmount());
            ps.setInt(2, importAccessary.getPriceImport());
            ps.setString(3, sdf.format(importAccessary.getCreatedDate()));
            ps.setInt(4, importAccessary.getAccessary().getId());
            ps.setInt(5, importAccessary.getSupplier().getId());
            ps.setInt(6, importAccessary.getBillAccessary().getId());
            ps.execute();
            result=true;
        } catch (SQLException ex) {
            Logger.getLogger(BillAccessaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
