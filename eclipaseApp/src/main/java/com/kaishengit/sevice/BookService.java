/**
 * 
 */
package com.kaishengit.sevice;

import java.util.List;

import com.kaishengit.entity.Book;
import com.kaishengit.entity.BookDao;
import com.kaishengit.entity.Page;
import com.kaishengit.exception.ServiceException;

/** 
* @ClassName: BookService 
* @Description: 
* @author: ����ΰ 
* @date: 2016��11��23�� ����10:49:33 
* @version 1.0
* 
*/

public class BookService {
	
	private BookDao bookDao = new BookDao();
	
	/**
	 * 
	 * @Description:����ȫ��
	 * @author: ����ΰ
	 * @return
	 * @return:List<Book>
	 * @time:2016��11��23�� ����2:00:12
	 */
	public List<Book> findByBookAllService(){
		
		List<Book> bookList = bookDao.findByBookAll();
		 
		return bookList;
	}
	/**
	 * ͨ��id����
	 * @Description:
	 * @author: ����ΰ
	 * @param id
	 * @return
	 * @return:Book
	 * @time:2016��11��24�� ����4:47:46
	 */
	public Book findByBookIdServlet(Integer id){
		return bookDao.findByBookId(id);
	}
	
	public void saveBookService(String name,String auther,String isbn,Integer total)
	throws ServiceException {
		Book book = new Book();
		if( bookDao.findByBookIsbn(isbn) == null){
			book.setName(name);
			book.setAuther(auther);
			book.setIsbn(isbn);
			book.setTotal(total);
			bookDao.saveBook(book);
		} else {
			throw new ServiceException("ISBN�ظ�����������");
		}
	}
	
	public void deleteBookServlet(Integer id){
		bookDao.deleteBook(id);
		
	}
	
	public Page findByLimitService(Integer pageNo){//��������ǰҳ��
		
		Integer count = Integer.valueOf(bookDao.findByCount().toString());
		//�������ǿ��Դ���Page����Ȼ��ѳ�ʼ��������ҳ���������֮����set�����󡣻���ֱ����д���췽�����Σ����Ҽ����ʼ�к���ҳ��������Ӧ����
		Page page = new Page<Book>(pageNo,count);//page��������������ֵ��ҳ���ͳ�ʼ��������Ҫ����ҳ�Ŵ�������//��ʵֻʣ��etimû�и�ֵ
		//����page���������ҡ�Ȼ���ٷ�װ��page��item��������
		List<Book> bookList = bookDao.findByBookPage(page.getStart(), page.getPageSize());
		page.setItem(bookList);
		return page;
	}
	
	
}
