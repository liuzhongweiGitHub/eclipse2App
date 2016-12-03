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
* @Description: 字符集过滤器
* @author: 刘忠伟 
* @date: 2016年11月27日 下午6:52:53 
* @version 1.0
* 
*/

public class CharsetFilter extends AbstractFilter{

	/* (non-Javadoc)
	 * 重写dofilter
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		servletRequest.setCharacterEncoding("UTF-8");//进入容器后请求就进入过滤器了
		servletResponse.setCharacterEncoding("UTF-8");//进出都要经过过滤器变字符编码，就不会出现乱码
		filterChain.doFilter(servletRequest, servletResponse);//通过过滤器
	}

	

}
