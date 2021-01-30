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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Service;
import model.TechnicalStaff;

/**
 *
 * @author Tien Thanh
 */
public class TechnicalStaffDAO extends DAO{

    public TechnicalStaffDAO() {
    }
    public ArrayList<TechnicalStaff> SearchTechnicalStaff(){
        ArrayList<TechnicalStaff> listTechnicalStaffs = new ArrayList<>();
            String sql= "SELECT * from tbltechnicalstaff WHERE isBusy = 0";
        try {
           
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                TechnicalStaff technicalStaff=new TechnicalStaff();
                technicalStaff.setId(rs.getInt(1));
                technicalStaff.setName(rs.getString(2));
                technicalStaff.setAddress(rs.getString(3));
                technicalStaff.setPhone(rs.getString(4));
                listTechnicalStaffs.add(technicalStaff);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TechnicalStaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTechnicalStaffs;
    }
    public TechnicalStaff getTechnicalStaffById(int id){
       TechnicalStaff technicalStaff=new TechnicalStaff();
       String sql="SELECT * FROM tbltechnicalstaff WHERE id = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                technicalStaff.setId(rs.getInt(1));
                technicalStaff.setName(rs.getString(2));
                technicalStaff.setAddress(rs.getString(3));
                technicalStaff.setPhone(rs.getString(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return technicalStaff;
    }
    public int setBusy(int id,int isBusy) throws SQLException{
        int result=0;
        try {
            con.setAutoCommit(false);
            String sql="UPDATE `qlgara_oto`.`tbltechnicalstaff` SET `isBusy` = ? WHERE (`id` = ?);";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, isBusy);
            ps.setInt(2, id);
            result=ps.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            con.rollback();
            con.setAutoCommit(true);
            Logger.getLogger(TechnicalStaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
