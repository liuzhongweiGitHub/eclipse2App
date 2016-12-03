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
* @author: ����ΰ 
* @date: 2016��11��23�� ����11:28:47 
* @version 1.0
* 
*/

public class BookDao {

	/**
	 * 
	 * @Description:��ѯȫ���鼮
	 * @author: ����ΰ
	 * @return
	 * @return:List<Book>
	 * @time:2016��11��23�� ����10:52:37
	 */
	public List<Book> findByBookAll(){
		String sql = "select * from book";
		return DbHelp.query(sql, new BeanListHandler<Book>(Book.class));
	}
	/**
	 * 
	 * @Description:����isbn��Ų�ѯ�Ƿ��ظ�
	 * @author: ����ΰ
	 * @param isbn
	 * @return
	 * @return:Book
	 * @time:2016��11��24�� ����12:15:08
	 */
	public Book findByBookIsbn(String isbn){
		String sql = "select * from book where isbn = ?";
		return DbHelp.query(sql, new BeanHandler<Book>(Book.class), isbn);
	}
	/**
	 * 
	 * @Description:
	 * @author: ����ΰ
	 * @param book
	 * @return:void
	 * @time:2016��11��24�� ����12:25:37
	 */
	public void saveBook(Book book){
		String sql = "insert into book (name,auther,isbn,total,nownum) values (?,?,?,?,?)";
		DbHelp.update(sql, book.getName(),book.getAuther(),book.getIsbn(),book.getTotal(),book.getTotal());
	}
	/**
	 * 
	 * @Description:ɾ���鼮
	 * @author: ����ΰ
	 * @param id
	 * @return:void
	 * @time:2016��11��24�� ����4:35:25
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
	 * @Description:��ѯ�ܹ��鼮
	 * @author: ����ΰ
	 * @return
	 * @return:Long
	 * @time:2016��12��1�� ����11:32:57
	 */
	public Long findByCount(){
		String sql ="select count(*) from book";
		return DbHelp.query(sql, new ScalarHandler<Long>());//ScalarHandler�Ƿ���Long����
	}
	
	public List<Book> findByBookPage(Integer start,Integer pageSize){
		String sql = "select * from book limit ?,?";//��ʼ�кţ���ѯ����
		return DbHelp.query(sql, new BeanListHandler<Book>(Book.class),start,pageSize);//��ѯ����
	}
}
