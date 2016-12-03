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

/** 
* @ClassName: GetCookieServlet 
* @Description:从服务器获取cookie 
* @author: 刘忠伟 
* @date: 2016年11月25日 下午9:01:58 
* @version 1.0
* 
*/

public class GetCookieServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String check = req.getParameter("check");
		System.out.println(check);
		//如果没有点击复选框就不用记住帐号，不用创建cookie
	//	if(){
			//在服务端获取cookie，cookie是在客户每次发出请求时都会传过来，前提是服务器先给他发送过
			Cookie[] cookies = req.getCookies();//获取请求之中传过来的cookie多个是集合
			//可以获取cookie里面传入的值域名，域名后面的路径，过期时间
			
			if(cookies!=null){
				for(Cookie cookie:cookies){
			
				cookie.setMaxAge(0);
				cookie.setPath("/");
				cookie.setDomain("localhost");
				resp.addCookie(cookie);
			}
		//}
	}
	}
}
