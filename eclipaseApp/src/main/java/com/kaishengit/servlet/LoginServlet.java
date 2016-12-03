/**
 * 
 */
package com.kaishengit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.entity.Admin;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.sevice.AdminService;

/** 
* @ClassName: LoginServlet 
* @Description: ��¼
* @author: ����ΰ 
* @date: 2016��11��22�� ����10:30:59 
* @version 1.0
* 
*/

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	/* 
	 * doGet����������ת�������ٴ�����ת����ת��jsp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			//��ȡcookie
			String value = null;
			Cookie[] cookies = req.getCookies();//��ȡ����cookie
			if(cookies != null){
				for(Cookie cookie:cookies){
					if(cookie.getName().equals("username")){
						 value = cookie.getValue();
						break;
					}
				}
			
		}
			req.setAttribute("value", value);
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
			
	}
	/* (non-Javadoc)
	 * �����ύ
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminService adminService = new AdminService();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		String check = req.getParameter("check");
		
		if(StringUtils.isNotEmpty(check)){
		//�ύ�ɹ�֮�󣬾ʹ���cookie������get�����ȡ������ÿ�ε�¼ҳ��ͻ��ȡ����ֵ����ȥ
			Cookie cookie = new Cookie("username",username);
			cookie.setDomain("localhost");
			cookie.setHttpOnly(true);
			cookie.setMaxAge(60*60*24*7);
			cookie.setPath("/");
			resp.addCookie(cookie);
		}
		
		//ˢ�±�ҳ����ظ��ύ�����Ǵ���Ļ����ü�����¼����Ӱ�졣��ͬpost��get����ظ��ύ����
		try {
			Admin admin = adminService.login(username, password);
			//���е���˵����½�ɹ�,��½�ɹ�֮����ת��list����ѯ�����ұ��浽session����֤��¼����
			HttpSession session = req.getSession();
			session.setAttribute("admin",admin);
			resp.sendRedirect("/list");
		} catch (ServiceException e) {
			req.setAttribute("username", username);
			req.setAttribute("message", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}
		
		
	}
}
