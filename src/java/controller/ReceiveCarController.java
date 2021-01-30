package controller;

import dao.AccessaryDAO;
import dao.AccessaryUsedDAO;
import dao.CustomerDAO;
import dao.ReceiveCarDAO;
import dao.ServiceDAO;
import dao.ServiceUsedDAO;
import dao.TechnicalStaffDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Accessary;
import model.AccessaryUsed;
import model.Customer;
import model.ReceiveCar;
import model.Service;
import model.ServiceUsed;
import model.TechnicalStaff;

@WebServlet(urlPatterns = {"/nhan-xe/khach-hang", "/nhan-xe/chon-khach-hang",
    "/nhan-xe/dich-vu", "/nhan-xe/chon-dich-vu", "/nhan-xe/chon-phu-tung",
    "/nhan-xe/nhan-vien-ki-thuat", "/nhan-xe/chon-nhan-vien",
    "/nhan-xe/phieu-nhan-xe", "/nhan-xe/xac-nhan"})
public class ReceiveCarController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ArrayList<ServiceUsed> listServiceUseds = new ArrayList<>();
    ArrayList<AccessaryUsed> listAccessaryUseds = new ArrayList<>();
    Customer customer = null;
    TechnicalStaff technicalStaff = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String path = request.getServletPath();
            RequestDispatcher rd;
            HttpSession session;
            int id;

            switch (path) {
                case "/nhan-xe/khach-hang":
                    //load data
                    rd = request.getRequestDispatcher("/view/saler/receiveCar/SelectCustomer.jsp");
                    rd.forward(request, response);
                    break;

                case "/nhan-xe/chon-khach-hang":
                    id = Integer.parseInt(request.getParameter("id"));
                    customer = new CustomerDAO().getCustomerById(id);
                    session = request.getSession();
                    session.setAttribute("customer", customer);
                    response.sendRedirect(request.getContextPath() + "/nhan-xe/dich-vu");
                    break;
                case "/nhan-xe/dich-vu":
                    //load data
                    rd = request.getRequestDispatcher("/view/saler/receiveCar/SelectService.jsp");
                    rd.forward(request, response);
                    break;
                case "/nhan-xe/chon-dich-vu":
                    id = Integer.parseInt(request.getParameter("id"));
                    Service service = new ServiceDAO().getServicerById(id);
                    ServiceUsed serviceUsed = new ServiceUsed();
                    serviceUsed.setService(service);
                    serviceUsed.setAmount(1);
                    listServiceUseds.add(serviceUsed);
                    session = request.getSession();
                    session.setAttribute("listServiceUseds", listServiceUseds);
                    String msg = "Tiếp tục chọn Dịch vụ hoặc Tiếp theo";
                    request.setAttribute("message", msg);
                    rd = request.getRequestDispatcher("/view/saler/receiveCar/SelectService.jsp");
                    rd.forward(request, response);
                    break;

                case "/nhan-xe/chon-phu-tung":
                    id = Integer.parseInt(request.getParameter("id"));
                    Accessary accessary = new AccessaryDAO().getAccessaryById(id);
                    AccessaryUsed accessaryUsed = new AccessaryUsed();
                    accessaryUsed.setAccessary(accessary);
                    accessaryUsed.setAmount(1);
                    listAccessaryUseds.add(accessaryUsed);
                    session = request.getSession();
                    session.setAttribute("listAccessaryUseds", listAccessaryUseds);
                    msg = "Tiếp tục chọn Dịch vụ hoặc Tiếp theo";
                    request.setAttribute("message", msg);
                    rd = request.getRequestDispatcher("/view/saler/receiveCar/SelectService.jsp");
                    rd.forward(request, response);
                    break;

                case "/nhan-xe/nhan-vien-ki-thuat":
                    ArrayList<TechnicalStaff> listTechnicalStaffs = new TechnicalStaffDAO().SearchTechnicalStaff();
                    if (listTechnicalStaffs.size() == 0) {
                        msg = "!Các nhân viên kĩ thuật đều đang bận!";
                        request.setAttribute("message", msg);
                    }
                    request.setAttribute("listTechnicalStaffs", listTechnicalStaffs);
                    rd = request.getRequestDispatcher("/view/saler/receiveCar/SelectTechnicalStaff.jsp");
                    rd.forward(request, response);
                    break;

                case "/nhan-xe/chon-nhan-vien":
                    id = Integer.parseInt(request.getParameter("id"));
                    technicalStaff = new TechnicalStaffDAO().getTechnicalStaffById(id);
                    session = request.getSession();
                    session.setAttribute("technicalStaff", technicalStaff);
                    response.sendRedirect(request.getContextPath() + "/nhan-xe/phieu-nhan-xe");
                    break;
                case "/nhan-xe/phieu-nhan-xe":
                    //load data
                    int tongtien = 0;
                    for (int i = 0; i < listServiceUseds.size(); i++) {
                        tongtien += listServiceUseds.get(i).getAmount() * listServiceUseds.get(i).getService().getPrice();
                    }
                    for (int i = 0; i < listAccessaryUseds.size(); i++) {
                        tongtien += listAccessaryUseds.get(i).getAmount() * listAccessaryUseds.get(i).getAccessary().getPrice();
                    }
                    request.setAttribute("tongtien", tongtien);
                    rd = request.getRequestDispatcher("/view/saler/receiveCar/ReceiveCar.jsp");
                    rd.forward(request, response);
                    break;
                case "/nhan-xe/xac-nhan":
                    //Lưu vào CSDL
                    //Phân công nhân viên
                    id = technicalStaff.getId();
                     {
                        try {
                            new TechnicalStaffDAO().setBusy(id, 1);
                        } catch (SQLException ex) {
                            Logger.getLogger(ReceiveCarController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    //lưu phiếu nhận xe
                    ReceiveCar receiveCar = new ReceiveCar();
                    receiveCar.setCustomer(customer);
                    receiveCar.setTechnicalStaff(technicalStaff);
                    receiveCar.setIsPayed(0);
                    Date createdDate = new Date(System.currentTimeMillis());
                    receiveCar.setCreatedDate(createdDate);
                    int receiveCarId = 0;
                    try {
                        receiveCarId = new ReceiveCarDAO().AddReceiveCar(receiveCar);
                    } catch (SQLException ex) {
                        Logger.getLogger(ReceiveCarController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    receiveCar.setId(receiveCarId);
                    //lưu DS dịch vụ sử dụng
                    ServiceUsedDAO serviceUsedDAO = new ServiceUsedDAO();
                    AccessaryUsedDAO accessaryUsedDAO = new AccessaryUsedDAO();
                    for (int i = 0; i < listServiceUseds.size(); i++) {
                        listServiceUseds.get(i).setCreatedDate(createdDate);
                        listServiceUseds.get(i).setReceiveCar(receiveCar);
                        try {
                            serviceUsedDAO.addNewServiceUsed(listServiceUseds.get(i));
                        } catch (SQLException ex) {
                            Logger.getLogger(ReceiveCarController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    for (int i = 0; i < listAccessaryUseds.size(); i++) {
                        listAccessaryUseds.get(i).setCreatedDate(createdDate);
                        listAccessaryUseds.get(i).setReceiveCar(receiveCar);
                        try {
                            accessaryUsedDAO.addNewAccessaryUsed(listAccessaryUseds.get(i));
                        } catch (SQLException ex) {
                            Logger.getLogger(ReceiveCarController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    //sau khi Lưu hết thì reset các bien
                    listServiceUseds.clear();
                    listAccessaryUseds.clear();

                    response.sendRedirect(request.getContextPath() + "");
                    break;

            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        System.out.println(action);
        if (action != null && action.equals("searchCustomer")) {
            String message;
            String url;
            String keyword = request.getParameter("keyword");

            ArrayList<Customer> listCustomers = new CustomerDAO().SearchCustomer(keyword);
            System.out.println(listCustomers.size());
            if (listCustomers.size() == 0) {

                message = "!DS trống, tìm lại hoặc thêm mới Khách hàng";
                request.setAttribute("message", message);

            }
            request.setAttribute("listCustomer", listCustomers);
            url = "/view/saler/receiveCar/SelectCustomer.jsp";// Chỉ rõ url đến view nào
            RequestDispatcher rd = request.getRequestDispatcher("/view/saler/receiveCar/SelectCustomer.jsp");
            rd.forward(request, response);

        }
        if (action != null && action.equals("searchService")) {
            String message;
            String url;
            String keyword = request.getParameter("keyword");
            ArrayList<Service> listServices = new ServiceDAO().SearchService(keyword);
            ArrayList<Accessary> listAccessaries = new AccessaryDAO().SearchAccessary(keyword);

            if (listServices.size() == 0 && listAccessaries.size() == 0) {
                message = "!Sai từ khóa, DS trống, Vui lòng nhập lại ";
                request.setAttribute("message", message);
            }
            request.setAttribute("listServices", listServices);
            request.setAttribute("listAccessaries", listAccessaries);
            url = "/view/saler/receiveCar/SelectService.jsp";// Chỉ rõ url đến view nào
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }
}
