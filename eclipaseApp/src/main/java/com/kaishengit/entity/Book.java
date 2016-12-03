/**
 * 
 */
package com.kaishengit.entity;

/** 
* @ClassName: Book 
* @Description: 
* @author: 刘忠伟 
* @date: 2016年11月23日 上午10:49:43 
* @version 1.0
* 
*/

public class Book {

	private Integer id;
	private String name;
	private String auther;
	private String isbn;
	private Integer total;
	private Integer nownum;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getNownum() {
		return nownum;
	}
	public void setNownum(Integer nownum) {
		this.nownum = nownum;
	}
	
	
}
