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
* @author: ����ΰ 
* @date: 2016��11��25�� ����8:29:34 
* @version 1.0
* 
*/

public class SetCookieServlet extends HttpServlet{//��servlet�϶�Ҫ����

	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����cookie
		Cookie cookie = new Cookie("yadan","yadan");
		cookie.setDomain("localhost");//����
		cookie.setPath("/");//�����µ�·��
		cookie.setMaxAge(60*60*24*7);//cookie��������
		//�Ѵ�cookie���͸��ͻ���
		resp.addCookie(cookie);
		
	}
	
}
