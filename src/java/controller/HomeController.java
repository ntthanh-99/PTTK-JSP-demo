package controller;

import dao.EmployeeDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet(urlPatterns = {"/trang-chu","/nhan-vien","/khach-hang","/dich-vu","/phu-tung","/nhan-xe","/nhap-phu-tung","/thong-ke/nha-cung-cap"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static Employee employee;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
            try {
                String path = request.getServletPath();
                RequestDispatcher rd;
                switch(path){
                    case "/nhan-vien":
                        response.sendRedirect(request.getContextPath() + "/nhan-vien/DS-nhan-vien");
                        break;
                    case "/khach-hang":
                        response.sendRedirect(request.getContextPath() + "/khach-hang/DS-khach-hang");
                        break;
                        
                    case "/dich-vu":
                        rd= request.getRequestDispatcher("/view/manager/DSdichvu.jsp");
                        rd.forward(request, response);
                        break;
                        
                    case "/phu-tung":
                        rd= request.getRequestDispatcher("/view/manager/DSphutung.jsp");
                        rd.forward(request, response);
                        break;
                     
                    case "/nhan-xe":
                        response.sendRedirect(request.getContextPath() + "/nhan-xe/khach-hang");
                        break;    
                        
                    case "/dang-nhap":
                        rd= request.getRequestDispatcher("/view/employee/login.jsp");
                        rd.forward(request, response);
                        break;
                    case "/nhap-phu-tung":
                         response.sendRedirect(request.getContextPath() + "/nhap-phu-tung/nha-cung-cap");
                        break;
                    case "/thong-ke/nha-cung-cap":
                         response.sendRedirect(request.getContextPath() + "/thong-ke/nha-cung-cap/loai-thong-ke");
                        break;
                        
                    default:
                        rd= request.getRequestDispatcher("/view/home/home.jsp");
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
                
		if(action != null && action.equals("login")){
                    String message;
                    String url;
                    String username= request.getParameter("username");
                    String password= request.getParameter("password");
                    Employee user= new Employee();
                    user.setUsername(username);
                    user.setPassword(password);
                    
                    if(new EmployeeDAO().checkLogin(user)){
                        response.sendRedirect(request.getContextPath() + "/trang-chu");
                    }
                    else{
                        message="!Tài khoản hoặc mật khẩu không chính xác";
                        request.setAttribute("message", message);
                        url="/view/user/login.jsp";// Chỉ rõ url đến view nào
                        RequestDispatcher rd = request.getRequestDispatcher(url);
                        rd.forward(request, response);
                    }
                }
	}
}
