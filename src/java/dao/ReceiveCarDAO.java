/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ReceiveCar;

/**
 *
 * @author Tien Thanh
 */
public class ReceiveCarDAO extends DAO{

    public ReceiveCarDAO() {
    }
    public int AddReceiveCar(ReceiveCar receiveCar) throws SQLException{
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         int result=0;
        try {
            con.setAutoCommit(false);
            String sql="INSERT INTO tblreceivecar (description,createdDate, isPayed, tblTechnicalStaffid, tblCustomerid) VALUES (?,?,?,?,?);";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, receiveCar.getDescription());
            ps.setString(2, sdf.format(receiveCar.getCreatedDate()));
            ps.setInt(3, receiveCar.isIsPayed());
            ps.setInt(4, receiveCar.getTechnicalStaff().getId());
            ps.setInt(5, receiveCar.getCustomer().getId());
            ps.execute();
            con.commit();

            String sql2="SELECT * FROM qlgara_oto.tblreceivecar;";
            ps=con.prepareStatement(sql2);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                result=rs.getInt(1);
            }
        } catch (SQLException ex) {
            con.rollback();
            con.setAutoCommit(true);
            Logger.getLogger(ReceiveCarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
