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
* @Description:�ӷ�������ȡcookie 
* @author: ����ΰ 
* @date: 2016��11��25�� ����9:01:58 
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
		//���û�е����ѡ��Ͳ��ü�ס�ʺţ����ô���cookie
	//	if(){
			//�ڷ���˻�ȡcookie��cookie���ڿͻ�ÿ�η�������ʱ���ᴫ������ǰ���Ƿ������ȸ������͹�
			Cookie[] cookies = req.getCookies();//��ȡ����֮�д�������cookie����Ǽ���
			//���Ի�ȡcookie���洫���ֵ���������������·��������ʱ��
			
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
