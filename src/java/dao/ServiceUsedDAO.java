/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ServiceUsed;

/**
 *
 * @author Tien Thanh
 */
public class ServiceUsedDAO extends DAO{

    public ServiceUsedDAO() {
    }
    public void addNewServiceUsed(ServiceUsed serviceUsed) throws SQLException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            con.setAutoCommit(false);
            String sql="INSERT INTO tblserviceused (amount,saleoff,price,createdDate,tblServiceid, tblReceiveCarid) VALUES (?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, serviceUsed.getAmount());
            ps.setInt(2, serviceUsed.getSaleoff());
            ps.setInt(3, serviceUsed.getPrice());
            ps.setString(4, sdf.format(serviceUsed.getCreatedDate()));
            ps.setInt(5, serviceUsed.getService().getId());
            ps.setInt(6, serviceUsed.getReceiveCar().getId());
            ps.execute();
            con.commit();
        } catch (SQLException ex) {
            con.rollback();
            con.setAutoCommit(true);
            Logger.getLogger(ServiceUsedDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
