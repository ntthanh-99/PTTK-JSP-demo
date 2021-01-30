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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 *
 * @author Tien Thanh
 */
public class CustomerDAO extends DAO{

    public CustomerDAO() {
    }
    public ArrayList<Customer> SearchCustomer(String name){
       ArrayList<Customer> listCustomers = new ArrayList<>();
       String sql="SELECT * FROM tblcustomer WHERE name Like ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Customer customer=new Customer();
                customer.setId(rs.getInt(1));
                customer.setName(rs.getString(2));
                customer.setAddress(rs.getString(3));
                customer.setPhone(rs.getString(5));
                customer.setEmail(rs.getString(4));
                listCustomers.add(customer);
            }
        } catch (SQLException ex) {
        }
       return listCustomers;
    }
    public ArrayList<Customer> getAllCustomer(){
        ArrayList<Customer> result=new ArrayList<>();
        try {
            String sql="SELECT * FROM tblcustomer";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
               Customer customer=new Customer();
               customer.setId(rs.getInt(1));
               customer.setName(rs.getString(2));
               customer.setAddress(rs.getString(3));
               customer.setEmail(rs.getString(4));
               customer.setPhone(rs.getString(5));
               result.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public Customer getCustomerById(int id){
       Customer customer = new Customer();
       String sql="SELECT * FROM tblcustomer WHERE id = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                customer.setId(rs.getInt(1));
                customer.setName(rs.getString(2));
                customer.setAddress(rs.getString(3));
                customer.setPhone(rs.getString(5));
                customer.setEmail(rs.getString(4));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return customer;
    }
    public boolean AddNewCustomer(Customer customer){
        boolean result= true;
        try {
            
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String sql="INSERT INTO tblcustomer(name,address,email,phone,createddate) VALUE(?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhone());
            ps.setString(5, sdf.format(new Date(System.currentTimeMillis())));
            ps.execute();
            result=true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public int updateCustomer(Customer customer){
        int result=0;
        try {
            String sql="UPDATE tblcustomer SET name=?,address=?,email=?,phone=?,modifiedDate=? WHERE id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhone());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(5, sdf.format(new Date(System.currentTimeMillis())));
            ps.setInt(6, customer.getId());
            result=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public boolean deleteCustomer(int id){
        boolean result=false;
        try {
            String sql="DELETE FROM tblcustomer WHERE id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            result=true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
