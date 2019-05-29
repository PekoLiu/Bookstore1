package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 处理所有请求编码
 */
@WebFilter(urlPatterns = { "/*" })
public class CharsetFilter implements Filter {

	public void destroy() {
		System.out.println("filter销毁");
	}

	//处理请求和响应
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("接收请求");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
        //过滤器链实现放行
		chain.doFilter(request, response);
		
		System.out.println("接收响应");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}