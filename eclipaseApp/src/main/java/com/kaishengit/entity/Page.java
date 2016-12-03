/**
 * 
 */
package com.kaishengit.entity;

import java.util.List;

/** 
* @ClassName: Page 
* @Description: 对于分页来说，需要许多关于页数的属性（当前页数，总页数，总行数，每页行数，每页的初始行号用来查询，查询的每页数据给List<T> item属性），所以创建一个封装类
* @author: 刘忠伟 
* @date: 2016年12月1日 上午11:14:08 
* @version 1.0
* 
*/

public class Page<T> {

	private Integer pageNo;//当前页数
	private Integer totals;//总行数
//这两个是需要输入，其他是通过算出来的
	
	private Integer totalPage;//总页数totals/pageSize
	private Integer pageSize = 2;//每页显示行数2个
	private Integer start;//每页的初始行数，pageSize*(page-1)用与limit start,pageSize
	private List<T> item;//把每页的数据封装到item，用泛型，是封装数据的类型，封装的是书Book类型
  	
	//重写构造方法。也可以不重写，值计算完成后set赋值就行
	public Page(Integer pageNo,Integer totals){
		if(pageNo < 1){
			//页数page是通过重定向传过来的。可以在地址栏修改。需要规定其范围,小于1的都为第一页
			pageNo = 1;
		}
		this.totals = totals;//实力变量变为这个
			//计算总页数
		totalPage = totals/pageSize;
		if(totals%pageSize != 0){
			totalPage++;
		}
		
		if(pageNo>totalPage){//p大于最大页数为最大页数
			pageNo = totalPage;
		}
		this.pageNo = pageNo;//实例变量赋值
		//计算每页的初始行数
		start = pageSize * ( pageNo - 1 );
	}
	
	
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotals() {
		return totals;
	}
	public void setTotals(Integer totals) {
		this.totals = totals;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public List<T> getItem() {
		return item;
	}
	public void setItem(List<T> item) {
		this.item = item;
	}
	
	
	
	
	
}
