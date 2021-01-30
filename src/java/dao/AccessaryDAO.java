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
import model.Accessary;
import model.Customer;
import model.Service;

/**
 *
 * @author Tien Thanh
 */
public class AccessaryDAO extends DAO{

    public AccessaryDAO() {
    }
    public ArrayList<Accessary> SearchAccessary(String keyword){
        ArrayList<Accessary> listAccessaries = new ArrayList<>();
        String sql="SELECT * FROM tblaccessary WHERE name Like ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Accessary accessary=new Accessary();
                accessary.setId(rs.getInt(1));
                accessary.setName(rs.getString(2));
                accessary.setDescription(rs.getString(4));
                accessary.setRemainAmount(rs.getInt(5));
                accessary.setPrice(rs.getInt(6));
                listAccessaries.add(accessary);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listAccessaries;
    }
    public Accessary getAccessaryById(int id){
       Accessary accessary=new Accessary();
       String sql="SELECT * FROM tblaccessary WHERE id = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                accessary.setId(rs.getInt(1));
                accessary.setName(rs.getString(2));
                accessary.setDescription(rs.getString(4));
                accessary.setRemainAmount(rs.getInt(5));
                accessary.setPrice(rs.getInt(6));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return accessary;
    }
    public void setAmount(int id, int amount){
        try {
            String sql="UPDATE `qlgara_oto`.`tblaccessary` SET `remainamount` = ? WHERE (`id` = ?);";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, amount);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccessaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean AddNewAccessay(Accessary accessary){
        return true;
    }
}
