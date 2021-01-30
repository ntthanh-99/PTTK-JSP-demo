/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
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

/**
 *
 * @author Tien Thanh
 */
@WebServlet(urlPatterns = {"/khach-hang/DS-khach-hang","/khach-hang/them","/khach-hang/sua","/khach-hang/xoa"})
public class CustomerController extends HttpServlet{
    Customer customer=null;
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response){
        try {
            String path=request.getServletPath();
            RequestDispatcher rd;
            switch(path){
                case "/khach-hang/DS-khach-hang":
                    ArrayList<Customer> listCustomer=new CustomerDAO().getAllCustomer();
                    request.setAttribute("listCustomer", listCustomer);
                    rd=request.getRequestDispatcher("/view/home/customer/CustomerManager.jsp");
                    rd.forward(request, response);
                    break;
                case "/khach-hang/them":
                    rd=request.getRequestDispatcher("/view/home/customer/AddCustomer.jsp");
                    rd.forward(request, response);
                    break;
                case "/khach-hang/sua":
                    int id=Integer.parseInt(request.getParameter("id"));
                    Customer customer=new CustomerDAO().getCustomerById(id);
                    request.setAttribute("customer", customer);
                    rd=request.getRequestDispatcher("/view/home/customer/UpdateCustomer.jsp");
                    rd.forward(request, response);
                    break;
                case "/khach-hang/xoa":
                    id=Integer.parseInt(request.getParameter("id"));
                    boolean result=new CustomerDAO().deleteCustomer(id);
                    System.out.println("Delete:"+result);
                    response.sendRedirect("DS-khach-hang");
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
            Customer customer=new Customer();
            customer.setName(request.getParameter("name"));
            customer.setAddress(request.getParameter("address"));
            customer.setEmail(request.getParameter("email"));
            customer.setPhone(request.getParameter("phone"));
            if(action.equals("update")){
                customer.setId(Integer.parseInt(request.getParameter("id")));
                int result=new CustomerDAO().updateCustomer(customer);
                System.out.println("Update: "+result);
            }
            else{
                boolean result= new CustomerDAO().AddNewCustomer(customer);
                System.out.println("Add :"+ result);
            }
            try {
                response.sendRedirect("DS-khach-hang");
            } catch (IOException ex) {
                Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(action!=null && action.equals("searchCustomer")){
            try {
                String keyword=request.getParameter("keyword");
                ArrayList<Customer> listCustomer=new CustomerDAO().SearchCustomer(keyword);
                request.setAttribute("listCustomer", listCustomer);
                RequestDispatcher rd=request.getRequestDispatcher("/view/home/customer/ResultSearch.jsp");
                rd.forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
