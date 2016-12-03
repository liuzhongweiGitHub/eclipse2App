/**
 * 
 */
package com.kaishengit.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/** 
* @ClassName: AbstractFilter 
* @Description: ������ģʽ
* @author: ����ΰ 
* @date: 2016��11��27�� ����6:56:32 
* @version 1.0
* 
*/

public abstract class AbstractFilter implements Filter{

	/* (non-Javadoc)
	 *����
	 */
	public void destroy() {
	}

	/* (non-Javadoc)
	 * doFilter�����󷽷�
	 */
	public abstract void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException ;
	
	/* (non-Javadoc)
	 * ��ʼ��������xml����ҳ����д�����
	 */
	public void init(FilterConfig arg0) throws ServletException {
		//init-param	
		//param-name
		//param-value
		//��ȡ��config.getInittParam....
	}//������̳���filter����дfilter�̳д���

}
