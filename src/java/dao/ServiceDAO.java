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
import model.Customer;
import model.Service;

/**
 *
 * @author Tien Thanh
 */
public class ServiceDAO extends DAO{
    public ServiceDAO() {
    }
    public ArrayList<Service> SearchService(String keyword){
        ArrayList<Service> listServices = new ArrayList<>();
        String sql="SELECT * FROM tblservice WHERE name Like ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Service service=new Service();
                service.setId(rs.getInt(1));
                service.setName(rs.getString(2));
                service.setDescription(rs.getString(4));
                service.setPrice(rs.getInt(5));
                listServices.add(service);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listServices;
    }
    public Service getServicerById(int id){
       Service service=new Service();
       String sql="SELECT * FROM tblservice WHERE id = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                service.setId(rs.getInt(1));
                service.setName(rs.getString(2));
                service.setDescription(rs.getString(4));
                service.setPrice(rs.getInt(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return service;
    }
}
