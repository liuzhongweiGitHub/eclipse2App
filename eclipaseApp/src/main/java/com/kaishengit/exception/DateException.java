/**
 * 
 */
package com.kaishengit.exception;

/** 
* @ClassName: DateException 
* @Description: 数据库异常类，用于将强制捕获行异常变为运行时异常往上抛，不会出现没有处理就直接报错
* @author: 刘忠伟 
* @date: 2016年11月26日 下午10:06:41 
* @version 1.0
* 
*/

public class DateException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public DateException(){}
	public DateException(String message){
		super(message);
	}
	public DateException(String message,Throwable cause){
		super(message,cause);
	} 
	 public DateException(Throwable cause) {
	        super(cause);
	    }
}
