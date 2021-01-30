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
import model.Supplier;

/**
 *
 * @author Tien Thanh
 */
public class SupplierDAO extends DAO{

    public SupplierDAO() {
    }
    public boolean AddNewSupplier(Supplier supplier){
        return true;
    }
    public ArrayList<Supplier> SearchSupplier(String name){
        ArrayList<Supplier> listSuppliers=new ArrayList<>();
        String sql="SELECT * FROM tblsupplier WHERE name Like ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Supplier supplier=new Supplier();
                supplier.setId(rs.getInt(1));
                supplier.setName(rs.getString(2));
                supplier.setDescription(rs.getString(3));
                supplier.setAddress(rs.getString(4));
                supplier.setPhone(rs.getString(5));
                listSuppliers.add(supplier);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listSuppliers;
    }
    public Supplier getSupplierById(int id){
       Supplier supplier=new Supplier();
       String sql="SELECT * FROM tblsupplier WHERE id = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                supplier.setId(rs.getInt(1));
                supplier.setName(rs.getString(2));
                supplier.setDescription(rs.getString(3));
                supplier.setAddress(rs.getString(4));
                supplier.setPhone(rs.getString(5));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return supplier;
    }
}
