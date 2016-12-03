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
* @author: ����ΰ 
* @date: 2016��11��27�� ����9:53:58 
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
		//��ת��֧��ҳ��ǰҪ����servlet�����������token�����浽session������֧��jsp
		String uuid = UUID.randomUUID().toString();//����tokenΨһ��,������ת����String
		HttpSession session = req.getSession();
		session.setAttribute("token", uuid);//����session
		req.setAttribute("token", uuid);//����jsp
		req.getRequestDispatcher("/WEB-INF/views/pay.jsp").forward(req, resp);
	}
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String money = (String)req.getParameter("money");
		String token = (String)req.getParameter("token");
		
		//��ȡsession�����token
		HttpSession session = req.getSession();
		String sessionToken = (String)session.getAttribute("token");
		
		if(sessionToken != null && sessionToken.equals(token)){//��ʱ��֧���ɹ�
			System.out.println("֧��"+ money);
			System.out.println(token);
			//��һ��֧���꣬��Ҫɾ��session�����token
			session.removeAttribute("token");
			req.getRequestDispatcher("/WEB-INF/views/paysucceed.jsp").forward(req, resp);
		} else {
			System.out.println("else");
			req.getRequestDispatcher("/WEB-INF/views/payerorr.jsp").forward(req, resp);
			
		}
	}
}
