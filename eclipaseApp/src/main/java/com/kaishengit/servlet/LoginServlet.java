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
* @Description: 登录
* @author: 刘忠伟 
* @date: 2016年11月22日 下午10:30:59 
* @version 1.0
* 
*/

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	/* 
	 * doGet用来接受跳转，并且再次请求转发跳转到jsp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			//获取cookie
			String value = null;
			Cookie[] cookies = req.getCookies();//获取所有cookie
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
	 * 接受提交
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminService adminService = new AdminService();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		String check = req.getParameter("check");
		
		if(StringUtils.isNotEmpty(check)){
		//提交成功之后，就创建cookie，再在get里面获取，这样每次登录页面就会获取，把值传过去
			Cookie cookie = new Cookie("username",username);
			cookie.setDomain("localhost");
			cookie.setHttpOnly(true);
			cookie.setMaxAge(60*60*24*7);
			cookie.setPath("/");
			resp.addCookie(cookie);
		}
		
		//刷新本页面会重复提交，但是错误的话就让继续登录，不影响。不同post，get解决重复提交问题
		try {
			Admin admin = adminService.login(username, password);
			//运行到这说明登陆成功,登陆成功之后跳转到list，查询，并且保存到session，验证登录过了
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
