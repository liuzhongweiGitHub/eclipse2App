/**
 * 
 */
package com.kaishengit.exception;

/** 
* @ClassName: DateException 
* @Description: ���ݿ��쳣�࣬���ڽ�ǿ�Ʋ������쳣��Ϊ����ʱ�쳣�����ף��������û�д����ֱ�ӱ���
* @author: ����ΰ 
* @date: 2016��11��26�� ����10:06:41 
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
