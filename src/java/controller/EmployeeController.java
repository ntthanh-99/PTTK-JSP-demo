/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
import dao.EmployeeDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.Employee;

/**
 *
 * @author Tien Thanh
 */
@WebServlet(urlPatterns = {"/nhan-vien/DS-nhan-vien","/nhan-vien/them","/nhan-vien/sua","/nhan-vien/xoa"})
public class EmployeeController extends HttpServlet{
    Employee employee=null;
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response){
        try {
            String path=request.getServletPath();
            RequestDispatcher rd;
            switch(path){
                case "/nhan-vien/DS-nhan-vien":
                    ArrayList<Employee> listEmployee=new EmployeeDAO().getAllEmployee();
                    request.setAttribute("listEmployee", listEmployee);
                    rd=request.getRequestDispatcher("/view/home/employee/EmployeeManager.jsp");
                    rd.forward(request, response);
                    break;
                case "/nhan-vien/them":
                    rd=request.getRequestDispatcher("/view/home/employee/AddEmployee.jsp");
                    rd.forward(request, response);
                    break;
                case "/nhan-vien/sua":
                    int id=Integer.parseInt(request.getParameter("id"));
                    Employee employee=new EmployeeDAO().getEmployeeById(id);
                    request.setAttribute("employee", employee);
                    rd=request.getRequestDispatcher("/view/home/employee/UpdateEmployee.jsp");
                    rd.forward(request, response);
                    break;
                case "/nhan-vien/xoa":
                    id=Integer.parseInt(request.getParameter("id"));
                    boolean result=new EmployeeDAO().deleteEmployee(id);
                    System.out.println("Delete:"+result);
                    response.sendRedirect("DS-nhan-vien");
                    break;
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String action = request.getParameter("action");
        if(action.equals("update") ||action.equals("add")){
            Employee employee =new Employee();
            employee.setUsername(request.getParameter("username"));
            employee.setPassword(request.getParameter("password"));
            employee.setName(request.getParameter("name"));
            employee.setPosition(request.getParameter("position"));
            employee.setAddress(request.getParameter("address"));
            employee.setPhone(request.getParameter("phone"));
            if(action.equals("update")){
                employee.setId(Integer.parseInt(request.getParameter("id")));
                int result=new EmployeeDAO().updateEmployee(employee);
                System.out.println("Update: "+result);
            }
            else{
                boolean result= new EmployeeDAO().AddNewEmployee(employee);
                System.out.println("Add :"+ result);
            }
            try {
                response.sendRedirect("DS-nhan-vien");
            } catch (IOException ex) {
                Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(action!=null && action.equals("searchEmployee")){
            try {
                String keyword=request.getParameter("keyword");
                ArrayList<Employee> listEmployee=new EmployeeDAO().SearchEmployee(keyword);
                request.setAttribute("listEmployee", listEmployee);
                RequestDispatcher rd=request.getRequestDispatcher("/view/home/employee/ResultSearch.jsp");
                rd.forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //helo
}
