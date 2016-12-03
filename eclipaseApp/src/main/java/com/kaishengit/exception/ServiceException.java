/**
 * 
 */
package com.kaishengit.exception;

/** 
* @ClassName: ServiceException 
* @Description: 自定义运行时异常用于帐号密码错误时，抛出异常
* @author: 刘忠伟 
* @date: 2016年11月23日 上午10:11:17 
* @version 1.0
* 
*/

public class ServiceException extends RuntimeException {
	
	 public ServiceException() {
	        super();
	    }
	
	 public ServiceException(String message) {
	        super(message);//代表执行父类构造方法
	    }
	 public ServiceException(String message, Throwable cause) {
	        super(message, cause);
	    }
	 public ServiceException(Throwable cause) {
	        super(cause);
	    }
}
