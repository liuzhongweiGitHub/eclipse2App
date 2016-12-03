/**
 * 
 */
package com.kaishengit.servlet.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaishengit.entity.Admin;

/** 
* @ClassName: LoginFilter 
* @Description: 
* @author: 刘忠伟 
* @date: 2016年11月27日 下午7:10:17 
* @version 1.0
* 
*/

public class LoginFilter extends AbstractFilter{//登录过滤器，

	/* (non-Javadoc)
	 * /,/static/开头，/login可以不用登录
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		//1. 获取用户访问的资源地址
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		if("/".equals(uri) || "/index.jsp".equals(uri) || "/login".equals(uri)
				|| uri.startsWith("/static/")) {
			filterChain.doFilter(request, response);
		} else {
			
			HttpSession session = request.getSession();
			Admin admin = (Admin) session.getAttribute("admin");
			
			if(admin != null) {
				filterChain.doFilter(request, response);
			} else {
				response.sendRedirect("/login?uri="+uri);
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
