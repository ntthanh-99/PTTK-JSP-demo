package controller;

import dao.AccessaryDAO;
import dao.SupplierDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static controller.HomeController.employee;
import dao.BillAccessaryDAO;
import dao.ImportAccessaryDAO;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Accessary;
import model.BillAccessary;
import model.ImportAccessary;
import model.Supplier;

@WebServlet(urlPatterns = {
    "/nhap-phu-tung/nha-cung-cap", "/nhap-phu-tung/chon-nha-cung-cap",
    "/nhap-phu-tung/phu-tung", "/nhap-phu-tung/chon-phu-tung",
    "/nhap-phu-tung/nhap","/nhap-phu-tung/tien-hanh-nhap",
    "/nhap-phu-tung/hoa-don-nhap", "/nhap-phu-tung/xac-nhan"})
public class ImportAccessaryController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ArrayList<ImportAccessary> listImportAccessaries=new ArrayList<>();
    Supplier supplier=null;
    int total;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String path = request.getServletPath();
            RequestDispatcher rd;
            HttpSession session;
            int id;

            switch (path) {
                case "/nhap-phu-tung/nha-cung-cap":
                    //load data
                    rd = request.getRequestDispatcher("/view/warehousestaff/importAccessary/SelectSupplier.jsp");
                    rd.forward(request, response);
                    break;

                case "/nhap-phu-tung/chon-nha-cung-cap":
                    id = Integer.parseInt(request.getParameter("id"));
                    supplier= new SupplierDAO().getSupplierById(id);
                    session = request.getSession();
                    session.setAttribute("supplier", supplier);
                    response.sendRedirect(request.getContextPath() + "/nhap-phu-tung/phu-tung");
                    break;
                case "/nhap-phu-tung/phu-tung":
                    //load data
                    rd = request.getRequestDispatcher("/view/warehousestaff/importAccessary/SelectAccessary.jsp");
                    rd.forward(request, response);
                    break;
                case "/nhap-phu-tung/chon-phu-tung":
                    id = Integer.parseInt(request.getParameter("id"));
                    Accessary accessary=new AccessaryDAO().getAccessaryById(id);
                    request.setAttribute("accessary", accessary);
                    rd = request.getRequestDispatcher("/view/warehousestaff/importAccessary/ImportAccessary.jsp");
                    rd.forward(request, response);
                    break;
                case "/nhap-phu-tung/nhap":
                    //load data
                    rd = request.getRequestDispatcher("/view/warehousestaff/importAccessary/ImportAccessary.jsp");
                    rd.forward(request, response);
                    break;
                case "/nhap-phu-tung/hoa-don-nhap":
                    request.setAttribute("supplier", supplier);
                    request.setAttribute("listImportAccessaries", listImportAccessaries);
                    total=0;
                    for(int i=0;i<listImportAccessaries.size();i++){
                        total+=listImportAccessaries.get(i).getAmount()*listImportAccessaries.get(i).getPriceImport();
                    }
                    request.setAttribute("tongtien", total);
                    rd = request.getRequestDispatcher("/view/warehousestaff/importAccessary/BillAccessary.jsp");
                    rd.forward(request, response);
                    break;
                case "/nhap-phu-tung/xac-nhan":
                    //luu vao CSDL
                    Date createdDate = new Date(System.currentTimeMillis());
                    //luu Bill
                    BillAccessary billAccessary=new BillAccessary();
                    billAccessary.setTotal(total);
                    billAccessary.setCreatedDate(createdDate);
                    new BillAccessaryDAO().AddBillAccessary(billAccessary);
                    int billAccessaryId=new BillAccessaryDAO().getIdLater();
                    billAccessary.setId(billAccessaryId);
                    //luu importAccessar
                    for(int i=0;i<listImportAccessaries.size();i++){
                        listImportAccessaries.get(i).setBillAccessary(billAccessary);
                        listImportAccessaries.get(i).setCreatedDate(createdDate);
                        new ImportAccessaryDAO().addImportAccessary(listImportAccessaries.get(i));
                    }
                    //luu Amount of Accessary
                    for(int i=0;i<listImportAccessaries.size();i++){
                        int amountUpdate= listImportAccessaries.get(i).getAccessary().getRemainAmount()
                                + listImportAccessaries.get(i).getAmount();
                        int accessaryId=listImportAccessaries.get(i).getAccessary().getId();
                        new AccessaryDAO().setAmount(accessaryId, amountUpdate);
                    }
                    //reset các biến
                    supplier = null;
                    listImportAccessaries.clear();
                    total=0;
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
        if (action != null && action.equals("searchSupplier")) {
            String message;
            String url;
            String keyword = request.getParameter("keyword");

            ArrayList<Supplier> listSuppliers = new SupplierDAO().SearchSupplier(keyword);
            if (listSuppliers.size() == 0) {
                message = "!DS trống, tìm lại hoặc thêm mới Khách hàng";
                request.setAttribute("message", message);

            }
            request.setAttribute("listSuppliers", listSuppliers);
            url = "/view/warehousestaff/importAccessary/SelectSupplier.jsp";// Chỉ rõ url đến view nào
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        }
        if (action != null && action.equals("searchAccessary")) {
            String message;
            String url;
            String keyword = request.getParameter("keyword");
            ArrayList<Accessary> listAccessaries = new AccessaryDAO().SearchAccessary(keyword);

            if (listAccessaries.size() == 0) {
                message = "!Sai từ khóa, DS trống, Vui lòng nhập lại ";
                request.setAttribute("message", message);
            }
            request.setAttribute("listAccessaries", listAccessaries);
            url = "/view/warehousestaff/importAccessary/SelectAccessary.jsp";// Chỉ rõ url đến view nào
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
        if (action != null && action.equals("importAccessary")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Accessary accessary=new AccessaryDAO().getAccessaryById(id);
            String amount=request.getParameter("soluong");
            String priceImport=request.getParameter("gianhap");
            ImportAccessary importAccessary=new ImportAccessary();
            importAccessary.setSupplier(supplier);
            importAccessary.setAccessary(accessary);
            importAccessary.setAmount(Integer.parseInt(amount));
            importAccessary.setPriceImport(Integer.parseInt(priceImport));
            listImportAccessaries.add(importAccessary);
            String msg= "Nhập thành công!!";
            request.setAttribute("message", msg);
            RequestDispatcher rd = request.getRequestDispatcher("/view/warehousestaff/importAccessary/ImportAccessary.jsp");
            rd.forward(request, response);    
      
        }
    }
}
