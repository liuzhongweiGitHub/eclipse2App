/**
 * 
 */
package com.kaishengit.exception;

/** 
* @ClassName: ServiceException 
* @Description: �Զ�������ʱ�쳣�����ʺ��������ʱ���׳��쳣
* @author: ����ΰ 
* @date: 2016��11��23�� ����10:11:17 
* @version 1.0
* 
*/

public class ServiceException extends RuntimeException {
	
	 public ServiceException() {
	        super();
	    }
	
	 public ServiceException(String message) {
	        super(message);//����ִ�и��๹�췽��
	    }
	 public ServiceException(String message, Throwable cause) {
	        super(message, cause);
	    }
	 public ServiceException(Throwable cause) {
	        super(cause);
	    }
}
