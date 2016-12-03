/**
 * 
 */
package com.kaishengit.servlet.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.crypto.dsig.spec.XPathType.Filter;



/** 
* @ClassName: CharsetFilter 
* @Description: �ַ���������
* @author: ����ΰ 
* @date: 2016��11��27�� ����6:52:53 
* @version 1.0
* 
*/

public class CharsetFilter extends AbstractFilter{

	/* (non-Javadoc)
	 * ��дdofilter
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		servletRequest.setCharacterEncoding("UTF-8");//��������������ͽ����������
		servletResponse.setCharacterEncoding("UTF-8");//������Ҫ�������������ַ����룬�Ͳ����������
		filterChain.doFilter(servletRequest, servletResponse);//ͨ��������
	}

	

}
