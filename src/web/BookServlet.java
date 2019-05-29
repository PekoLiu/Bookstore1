package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;
import service.impl.BookServiceImpl;

/**
 * 执行所有和book相关的操作
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//2.接收参数
		String method = request.getParameter("method");
		String bid = request.getParameter("bid");
		//3.执行业务
		BookService service = new BookServiceImpl();
		if("del".equals(method)) {
			service.delete(Integer.parseInt(bid));
		}
		
		request.setAttribute("books", service.queryAll());
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

}