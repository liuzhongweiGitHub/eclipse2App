/**
 * 
 */
package com.kaishengit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaishengit.entity.Admin;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.sevice.BookService;

/** 
* @ClassName: AddBookServlet 
* @Description: 
* @author: 刘忠伟 
* @date: 2016年11月23日 下午12:13:16 
* @version 1.0
* 
*/

public class AddBookServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//判断是否登录
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin != null){	
			req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/login");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String auther = req.getParameter("auther");
		String isbn = req.getParameter("isbn");
		String total = req.getParameter("total");
		BookService bookService = new BookService();
		
		try {
			bookService.saveBookService(name, auther, isbn, Integer.valueOf(total));
			//走到这里就表示添加成功,跳到/list输出全部。。为了保证不重复提交
			resp.sendRedirect("/list");//成功就直接跳到输出页面，再刷新就刷新输出，不会重复提交
		} catch (ServiceException e) {
			//登录失败跳转回去add.jsp
			req.setAttribute("name", name);
			req.setAttribute("auther", auther);
			req.setAttribute("isbn", isbn);
			req.setAttribute("total", total);
			req.setAttribute("message", e.getMessage());
			req.getRequestDispatcher("WEB-INF/views/add.jsp").forward(req, resp);
		}
	}
}
