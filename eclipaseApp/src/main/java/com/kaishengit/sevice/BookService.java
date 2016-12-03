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
* @author: 刘忠伟 
* @date: 2016年11月23日 上午10:49:33 
* @version 1.0
* 
*/

public class BookService {
	
	private BookDao bookDao = new BookDao();
	
	/**
	 * 
	 * @Description:查找全部
	 * @author: 刘忠伟
	 * @return
	 * @return:List<Book>
	 * @time:2016年11月23日 下午2:00:12
	 */
	public List<Book> findByBookAllService(){
		
		List<Book> bookList = bookDao.findByBookAll();
		 
		return bookList;
	}
	/**
	 * 通过id查找
	 * @Description:
	 * @author: 刘忠伟
	 * @param id
	 * @return
	 * @return:Book
	 * @time:2016年11月24日 下午4:47:46
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
			throw new ServiceException("ISBN重复请重新输入");
		}
	}
	
	public void deleteBookServlet(Integer id){
		bookDao.deleteBook(id);
		
	}
	
	public Page findByLimitService(Integer pageNo){//传参数当前页数
		
		Integer count = Integer.valueOf(bookDao.findByCount().toString());
		//这里我们可以创建Page对象，然后把初始行数，总页数，算出来之后再set给对象。或者直接重写构造方法传参，并且计算初始行和总页数赋给对应属性
		Page page = new Page<Book>(pageNo,count);//page对象有两个属性值总页数和初始行数，需要根据页号创建对象//其实只剩下etim没有赋值
		//根据page对象来查找。然后再封装到page的item属性里面
		List<Book> bookList = bookDao.findByBookPage(page.getStart(), page.getPageSize());
		page.setItem(bookList);
		return page;
	}
	
	
}
