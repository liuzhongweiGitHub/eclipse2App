/**
 * 
 */
package com.kaishengit.entity;

import java.util.List;

/** 
* @ClassName: Page 
* @Description: ���ڷ�ҳ��˵����Ҫ������ҳ�������ԣ���ǰҳ������ҳ������������ÿҳ������ÿҳ�ĳ�ʼ�к�������ѯ����ѯ��ÿҳ���ݸ�List<T> item���ԣ������Դ���һ����װ��
* @author: ����ΰ 
* @date: 2016��12��1�� ����11:14:08 
* @version 1.0
* 
*/

public class Page<T> {

	private Integer pageNo;//��ǰҳ��
	private Integer totals;//������
//����������Ҫ���룬������ͨ���������
	
	private Integer totalPage;//��ҳ��totals/pageSize
	private Integer pageSize = 2;//ÿҳ��ʾ����2��
	private Integer start;//ÿҳ�ĳ�ʼ������pageSize*(page-1)����limit start,pageSize
	private List<T> item;//��ÿҳ�����ݷ�װ��item���÷��ͣ��Ƿ�װ���ݵ����ͣ���װ������Book����
  	
	//��д���췽����Ҳ���Բ���д��ֵ������ɺ�set��ֵ����
	public Page(Integer pageNo,Integer totals){
		if(pageNo < 1){
			//ҳ��page��ͨ���ض��򴫹����ġ������ڵ�ַ���޸ġ���Ҫ�涨�䷶Χ,С��1�Ķ�Ϊ��һҳ
			pageNo = 1;
		}
		this.totals = totals;//ʵ��������Ϊ���
			//������ҳ��
		totalPage = totals/pageSize;
		if(totals%pageSize != 0){
			totalPage++;
		}
		
		if(pageNo>totalPage){//p�������ҳ��Ϊ���ҳ��
			pageNo = totalPage;
		}
		this.pageNo = pageNo;//ʵ��������ֵ
		//����ÿҳ�ĳ�ʼ����
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
