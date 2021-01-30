package controller;

import dao.AccessaryDAO;
import dao.BillAccessaryDAO;
import dao.CustomerDAO;
import dao.ServiceDAO;
import dao.StatisticSupplierDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import model.BillAccessary;
import model.Customer;
import model.ImportAccessary;
import model.Service;
import model.SupplierStat;

@WebServlet(urlPatterns = {"/thong-ke/nha-cung-cap/loai-thong-ke",
    "/thong-ke/nha-cung-cap/thong-ke","/thong-ke/nha-cung-cap/chon-nha-cung-cap",
    "/thong-ke/nha-cung-cap/chi-tiet-nha-cung-cap",
    "/thong-ke/nha-cung-cap/chon-hoa-don"})
public class SupplierStatController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ArrayList<SupplierStat> listSupplierStats=new ArrayList<>();
    ArrayList<BillAccessary> listBillAccessarys=new ArrayList<>();
    ArrayList<ImportAccessary> listImportAccessaries=new ArrayList<>();
    BillAccessary billAccessary=null;
    SupplierStat supplierStat=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String path = request.getServletPath();
            RequestDispatcher rd;
            HttpSession session;
            int id;

            switch (path) {
                case "/thong-ke/nha-cung-cap/loai-thong-ke":
                    //load data
                    rd = request.getRequestDispatcher("/view/manager/statistic/SelectStat.jsp");
                    rd.forward(request, response);
                    break;
                case "/thong-ke/nha-cung-cap/thong-ke":
                    rd = request.getRequestDispatcher("/view/manager/statistic/supplierstat/StatisticSupplier.jsp");
                    rd.forward(request, response);
                    break;
                case "/thong-ke/nha-cung-cap/chon-nha-cung-cap":
                    id= Integer.parseInt(request.getParameter("id"));
                    for(int i=0;i<listSupplierStats.size();i++){
                        if(id==listSupplierStats.get(i).getId())
                        {
                             supplierStat=listSupplierStats.get(i);
                             break;
                        }
                    }
                {
                    try {
                        listBillAccessarys=new StatisticSupplierDAO().DetailSupplier(supplierStat);
                    } catch (ParseException ex) {
                        Logger.getLogger(SupplierStatController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    
                    request.setAttribute("supplierStat",supplierStat);
                    request.setAttribute("listBillAccessaries", listBillAccessarys);
                    rd = request.getRequestDispatcher("/view/manager/statistic/supplierstat/DetailSupplier.jsp");
                    rd.forward(request, response);
                    break;
                case "/thong-ke/nha-cung-cap/chon-hoa-don":
                    id= Integer.parseInt(request.getParameter("id"));
                    listImportAccessaries=new BillAccessaryDAO().searchBill(id);
                    for(int i=0;i<listImportAccessaries.size();i++){
                        Accessary accessary=new AccessaryDAO().getAccessaryById(listImportAccessaries.get(i).getAccessary().getId());
                        listImportAccessaries.get(i).setAccessary(accessary);
                    }
                    request.setAttribute("lisImportAccessaries", listImportAccessaries);
                    for(int i=0;i<listBillAccessarys.size();i++){
                        if(id==listBillAccessarys.get(i).getId())
                        {
                             billAccessary=listBillAccessarys.get(i);
                             break;
                        }
                    }
                    request.setAttribute("billAccessary", billAccessary);
                    rd = request.getRequestDispatcher("/view/manager/statistic/supplierstat/DetailBill.jsp");
                    rd.forward(request, response);
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
        if (action != null && action.equals("SupplierStat")) {
            try {
                String message;
                String url;
                
                String start= request.getParameter("startTime");
                String end=request.getParameter("endTime");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date startTime= sdf.parse(start);
                Date endTime= sdf.parse(end);
                
                listSupplierStats=new StatisticSupplierDAO().StatSupplier(startTime, endTime);
                request.setAttribute("listSupplierStats", listSupplierStats);
                RequestDispatcher rd = request.getRequestDispatcher("/view/manager/statistic/supplierstat/StatisticSupplier.jsp");
                rd.forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(SupplierStatController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }
}
