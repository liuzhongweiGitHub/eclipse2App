/**
 * 
 */
package com.kaishengit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.entity.Admin;
import com.kaishengit.entity.Book;
import com.kaishengit.entity.Page;
import com.kaishengit.sevice.BookService;

/** 
* @ClassName: ListServlet 
* @Description: 
* @author: 刘忠伟 
* @date: 2016年11月23日 上午10:46:55 
* @version 1.0
* 
*/

public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookService();
	
	/*
	 * 分页，当前页数是关键，把所有东西连接起来
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String p = req.getParameter("p");//页数
		Integer pageNo = 1;//初始值查询第一页，第一次进servlet跳到jsp，p为null,进来默认是第一页
		if(StringUtils.isNumeric(p)){//这个只能判断p是不纯数字组成的字符串，不能转数字
			pageNo = Integer.valueOf(p);//如果这里p大于最大页数或者小于1，都默认为第一页，在page的构造方法里面修改了
		} 
		//，因为是重定向到servlet,可以直接从地址栏进入servlet，首先判断是否登录
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin == null){
			resp.sendRedirect("/login");
		} else {
			Page page = bookService.findByLimitService(Integer.valueOf(pageNo));
			req.setAttribute("page", page);
			req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
			
		}
		
	}
	
}
