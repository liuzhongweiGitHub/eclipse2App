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

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.entity.Book;
import com.kaishengit.sevice.BookService;

/** 
* @ClassName: DeleteServlet 
* @Description: 
* @author: ����ΰ 
* @date: 2016��11��24�� ����4:25:20 
* @version 1.0
* 
*/

public class DeleteServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ɾ���ɹ�����ת��ȥ/list
		HttpSession session = req.getSession();
		if(session.getAttribute("admin") == null){
			resp.sendRedirect("/login");
		} else {
			String id = req.getParameter("id");
			if(StringUtils.isNumeric(id)){
				BookService bookService = new BookService();
				Book book = bookService.findByBookIdServlet(Integer.valueOf(id));
				if(book == null){
					resp.sendError(404, "û�ҵ�");
				} else {
					bookService.deleteBookServlet(Integer.valueOf(id));
					resp.sendRedirect("/list");
				}
			} else {
				resp.sendError(404, "���벻��ȷ");
			}
			
		}
		
	}
	
	
}
