/**
 * 
 */
package com.kaishengit.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** 
* @ClassName: PayServlet 
* @Description: 
* @author: 刘忠伟 
* @date: 2016年11月27日 上午9:53:58 
* @version 1.0
* 
*/

public class PayServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//跳转到支付页面前要经过servlet，在这里产生token，保存到session。传到支付jsp
		String uuid = UUID.randomUUID().toString();//创建token唯一的,是数字转换成String
		HttpSession session = req.getSession();
		session.setAttribute("token", uuid);//传到session
		req.setAttribute("token", uuid);//传到jsp
		req.getRequestDispatcher("/WEB-INF/views/pay.jsp").forward(req, resp);
	}
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String money = (String)req.getParameter("money");
		String token = (String)req.getParameter("token");
		
		//获取session里面的token
		HttpSession session = req.getSession();
		String sessionToken = (String)session.getAttribute("token");
		
		if(sessionToken != null && sessionToken.equals(token)){//这时候支付成功
			System.out.println("支付"+ money);
			System.out.println(token);
			//第一次支付完，就要删除session里面的token
			session.removeAttribute("token");
			req.getRequestDispatcher("/WEB-INF/views/paysucceed.jsp").forward(req, resp);
		} else {
			System.out.println("else");
			req.getRequestDispatcher("/WEB-INF/views/payerorr.jsp").forward(req, resp);
			
		}
	}
}
