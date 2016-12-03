/**
 * 
 */
package com.kaishengit.entity;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.kaishengit.Utils.DbHelp;

/** 
* @ClassName: BookDao 
* @Description: 
* @author: 刘忠伟 
* @date: 2016年11月23日 上午11:28:47 
* @version 1.0
* 
*/

public class BookDao {

	/**
	 * 
	 * @Description:查询全部书籍
	 * @author: 刘忠伟
	 * @return
	 * @return:List<Book>
	 * @time:2016年11月23日 上午10:52:37
	 */
	public List<Book> findByBookAll(){
		String sql = "select * from book";
		return DbHelp.query(sql, new BeanListHandler<Book>(Book.class));
	}
	/**
	 * 
	 * @Description:根据isbn编号查询是否重复
	 * @author: 刘忠伟
	 * @param isbn
	 * @return
	 * @return:Book
	 * @time:2016年11月24日 下午12:15:08
	 */
	public Book findByBookIsbn(String isbn){
		String sql = "select * from book where isbn = ?";
		return DbHelp.query(sql, new BeanHandler<Book>(Book.class), isbn);
	}
	/**
	 * 
	 * @Description:
	 * @author: 刘忠伟
	 * @param book
	 * @return:void
	 * @time:2016年11月24日 下午12:25:37
	 */
	public void saveBook(Book book){
		String sql = "insert into book (name,auther,isbn,total,nownum) values (?,?,?,?,?)";
		DbHelp.update(sql, book.getName(),book.getAuther(),book.getIsbn(),book.getTotal(),book.getTotal());
	}
	/**
	 * 
	 * @Description:删除书籍
	 * @author: 刘忠伟
	 * @param id
	 * @return:void
	 * @time:2016年11月24日 下午4:35:25
	 */
	public void deleteBook(Integer id){
		String sql = "delete from book where id = ?";
		DbHelp.update(sql, id);
	}
	
	public Book findByBookId(Integer id){
		String sql = "select * from book where id = ?";
		return DbHelp.query(sql, new BeanHandler<Book>(Book.class), id);
	}
	/**
	 * 
	 * @Description:查询总共书籍
	 * @author: 刘忠伟
	 * @return
	 * @return:Long
	 * @time:2016年12月1日 上午11:32:57
	 */
	public Long findByCount(){
		String sql ="select count(*) from book";
		return DbHelp.query(sql, new ScalarHandler<Long>());//ScalarHandler是返回Long类型
	}
	
	public List<Book> findByBookPage(Integer start,Integer pageSize){
		String sql = "select * from book limit ?,?";//初始行号，查询个数
		return DbHelp.query(sql, new BeanListHandler<Book>(Book.class),start,pageSize);//查询集合
	}
}
