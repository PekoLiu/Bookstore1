package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.BookService;
import service.UserService;
import service.impl.BookServiceImpl;
import service.impl.UserServiceImpl;
/**
 * 处理用户操作相关所有请求和响应
 *
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserServlet() {
		System.out.println("王八蛋");
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//2.接收请求参数
		String method = request.getParameter("method");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService service = new UserServiceImpl();
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		//3.处理业务
		if("register".equals(method)) {//注册
			int rows = service.register(user);
			if(rows > 0) {//成功
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "注册失败");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
			return;
		}
		
		if("login".equals(method)) {//登录
			User u = service.login(user);
			if( u == null) {//登录失败
				request.setAttribute("msg", "登录失败");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else { //登陆成功
				//保存用户名称
				request.getSession().setAttribute("user", username);
				request.getRequestDispatcher("book").forward(request, response);
			}
			return;
		}
		
	}

}
