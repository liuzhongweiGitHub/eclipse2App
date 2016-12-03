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
* @ClassName: SetCookieServlet 
* @Description: 
* @author: 刘忠伟 
* @date: 2016年11月25日 下午8:29:34 
* @version 1.0
* 
*/

public class SetCookieServlet extends HttpServlet{//是servlet肯定要配置

	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建cookie
		Cookie cookie = new Cookie("yadan","yadan");
		cookie.setDomain("localhost");//域名
		cookie.setPath("/");//域名下的路径
		cookie.setMaxAge(60*60*24*7);//cookie生存周期
		//把此cookie发送给客户端
		resp.addCookie(cookie);
		
	}
	
}
