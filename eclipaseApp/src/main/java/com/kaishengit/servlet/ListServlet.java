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
* @author: ����ΰ 
* @date: 2016��11��23�� ����10:46:55 
* @version 1.0
* 
*/

public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookService();
	
	/*
	 * ��ҳ����ǰҳ���ǹؼ��������ж�����������
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String p = req.getParameter("p");//ҳ��
		Integer pageNo = 1;//��ʼֵ��ѯ��һҳ����һ�ν�servlet����jsp��pΪnull,����Ĭ���ǵ�һҳ
		if(StringUtils.isNumeric(p)){//���ֻ���ж�p�ǲ���������ɵ��ַ���������ת����
			pageNo = Integer.valueOf(p);//�������p�������ҳ������С��1����Ĭ��Ϊ��һҳ����page�Ĺ��췽�������޸���
		} 
		//����Ϊ���ض���servlet,����ֱ�Ӵӵ�ַ������servlet�������ж��Ƿ��¼
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
