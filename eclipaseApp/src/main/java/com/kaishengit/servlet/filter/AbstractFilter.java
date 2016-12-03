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
* @Description: 适配器模式
* @author: 刘忠伟 
* @date: 2016年11月27日 下午6:56:32 
* @version 1.0
* 
*/

public abstract class AbstractFilter implements Filter{

	/* (non-Javadoc)
	 *销毁
	 */
	public void destroy() {
	}

	/* (non-Javadoc)
	 * doFilter做抽象方法
	 */
	public abstract void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException ;
	
	/* (non-Javadoc)
	 * 初始化。可在xml配置页面进行传参数
	 */
	public void init(FilterConfig arg0) throws ServletException {
		//init-param	
		//param-name
		//param-value
		//获取，config.getInittParam....
	}//抽象类继承于filter，再写filter继承此类

}
