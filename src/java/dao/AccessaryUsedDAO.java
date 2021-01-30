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
import model.AccessaryUsed;


/**
 *
 * @author Tien Thanh
 */
public class AccessaryUsedDAO extends DAO{

    public AccessaryUsedDAO() {
    }
    public void addNewAccessaryUsed(AccessaryUsed accessaryUsed) throws SQLException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            con.setAutoCommit(false);
            String sql="INSERT INTO tblaccessaryused (amount,saleoff,price,createdDate,tblAccessaryid, tblReceiveCarid) VALUES (?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accessaryUsed.getAmount());
            ps.setInt(2, accessaryUsed.getSaleoff());
            ps.setInt(3, accessaryUsed.getPrice());
            ps.setString(4, sdf.format(accessaryUsed.getCreatedDate()));
            ps.setInt(5, accessaryUsed.getAccessary().getId());
            ps.setInt(6, accessaryUsed.getReceiveCar().getId());
            ps.execute();
            con.commit();
        } catch (SQLException ex) {
            con.rollback();
            con.setAutoCommit(true);
            Logger.getLogger(ServiceUsedDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
