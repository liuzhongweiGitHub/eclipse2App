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
* @author: ����ΰ 
* @date: 2016��11��27�� ����7:10:17 
* @version 1.0
* 
*/

public class LoginFilter extends AbstractFilter{//��¼��������

	/* (non-Javadoc)
	 * /,/static/��ͷ��/login���Բ��õ�¼
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		//1. ��ȡ�û����ʵ���Դ��ַ
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
