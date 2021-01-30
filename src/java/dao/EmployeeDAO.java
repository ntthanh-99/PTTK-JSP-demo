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
import model.Employee;

/**
 *
 * @author Tien Thanh
 */
public class EmployeeDAO extends DAO{

    public EmployeeDAO() {
    }
    public boolean checkLogin(Employee employee){
        boolean result = false;
        String sql="SELECT name , position FROM tbluser WHERE username = ? and password = ? ";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, employee.getUsername());
            ps.setString(2, employee.getPassword());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                employee.setName(rs.getString("name"));
                employee.setPosition(rs.getString("position"));
                result = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public ArrayList<Employee> SearchEmployee(String name){
       ArrayList<Employee> listEmployyee = new ArrayList<>();
       String sql="SELECT * FROM tblemployee WHERE name Like ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Employee employee=new Employee();
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString(4));
                employee.setPosition(rs.getString(5));
                employee.setAddress(rs.getString(6));
                employee.setPhone(rs.getString(7));
                listEmployyee.add(employee);
            }
        } catch (SQLException ex) {
        }
       return listEmployyee;
    }
    public ArrayList<Employee> getAllEmployee(){
        ArrayList<Employee> result=new ArrayList<>();
        try {
            String sql="SELECT * FROM tblemployee";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
               Employee employee=new Employee();
               employee.setId(rs.getInt(1));
               employee.setName(rs.getString(4));
               employee.setPosition(rs.getString(5));
               employee.setAddress(rs.getString(6));
               employee.setPhone(rs.getString(7));
               result.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public Employee getEmployeeById(int id){
       Employee employee = new Employee();
       String sql="SELECT * FROM tblemployee WHERE id = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
               employee.setId(rs.getInt(1));
               employee.setName(rs.getString(4));
               employee.setPosition(rs.getString(5));
               employee.setAddress(rs.getString(6));
               employee.setPhone(rs.getString(7));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return employee;
    }
    public boolean AddNewEmployee(Employee employee){
        boolean result= true;
        try {
            
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String sql="INSERT INTO tblemployee(username,password,name,position,address,phone,createddate) VALUE(?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, employee.getUsername());
            ps.setString(2, employee.getPassword());
            ps.setString(3, employee.getName());
            ps.setString(4, employee.getPosition());
            ps.setString(5, employee.getAddress());
            ps.setString(6, employee.getPhone());
            ps.setString(7, sdf.format(new Date(System.currentTimeMillis())));
            ps.execute();
            result=true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public int updateEmployee(Employee employee){
        int result=0;
        try {
            String sql="UPDATE tblemployee SET name=?,position=?,address=?,phone=?,modifiedDate=? WHERE id=?";
            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setString(1, employee.getUsername());
//            ps.setString(2, employee.getPassword());
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getPosition());
            ps.setString(3, employee.getAddress());
            ps.setString(4, employee.getPhone());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(5, sdf.format(new Date(System.currentTimeMillis())));
            ps.setInt(6, employee.getId());
            result=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public boolean deleteEmployee(int id){
        boolean result=false;
        try {
            String sql="DELETE FROM tblemployee WHERE id=?";
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
    