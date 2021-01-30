package controller;

import dao.EmployeeDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Employee;

@WebServlet(urlPatterns = {"/dang-nhap","/dang-ki","/quen-mat-khau"})
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
            try {
                String path = request.getServletPath();
                switch(path){
                    case "/dang-ky":
                        RequestDispatcher rd = request.getRequestDispatcher("/view/employee/registion.jsp");
                        rd.forward(request, response);
                        break;
                    case "/quen-mat-khau":
                        rd= request.getRequestDispatcher("/view/employee/forgotPassword.jsp");
                        rd.forward(request, response);
                        break;
                    default:
                        rd= request.getRequestDispatcher("/view/employee/login.jsp");
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
                        HttpSession session = request.getSession();
                        session.setAttribute("employee", user);
                        response.sendRedirect(request.getContextPath() + "/");
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
