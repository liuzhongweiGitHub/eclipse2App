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
* @author: 刘忠伟 
* @date: 2016年11月22日 下午10:41:11 
* @version 1.0
* 
*/

public class AdminService {
	
	private AdminDao adminDao = new AdminDao();
	/**
	 * 登录
	 * @Description:
	 * @author: 刘忠伟
	 * @param name
	 * @param password
	 * @return
	 * @return:Admin
	 * @time:2016年11月22日 下午10:44:15
	 */
	public Admin login(String username,String password) throws ServiceException{
		//Dao通过username查找
		Admin admin = adminDao.finByAdminName(username);
		
		if(admin != null && password.equals(admin.getCode())){
			return admin;
		} else {//帐号或者密码错误，抛出一个运行时异常，只要收到异常就密码错误
			throw new ServiceException("帐号或者密码错误！请重新输入");
		}
		
	}
}
