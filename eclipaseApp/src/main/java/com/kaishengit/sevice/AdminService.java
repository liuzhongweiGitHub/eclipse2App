/**
 * 
 */
package com.kaishengit.sevice;

import com.kaishengit.entity.Admin;
import com.kaishengit.entity.AdminDao;
import com.kaishengit.exception.ServiceException;

/** 
* @ClassName: AdminService 
* @Description: 
* @author: ����ΰ 
* @date: 2016��11��22�� ����10:41:11 
* @version 1.0
* 
*/

public class AdminService {
	
	private AdminDao adminDao = new AdminDao();
	/**
	 * ��¼
	 * @Description:
	 * @author: ����ΰ
	 * @param name
	 * @param password
	 * @return
	 * @return:Admin
	 * @time:2016��11��22�� ����10:44:15
	 */
	public Admin login(String username,String password) throws ServiceException{
		//Daoͨ��username����
		Admin admin = adminDao.finByAdminName(username);
		
		if(admin != null && password.equals(admin.getCode())){
			return admin;
		} else {//�ʺŻ�����������׳�һ������ʱ�쳣��ֻҪ�յ��쳣���������
			throw new ServiceException("�ʺŻ��������������������");
		}
		
	}
}
