/**
 * 
 */
package com.kaishengit.entity;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kaishengit.Utils.DbHelp;

/** 
* @ClassName: AdminDao 
* @Description: 
* @author: 刘忠伟 
* @date: 2016年11月22日 下午10:46:10 
* @version 1.0
* 
*/

public class AdminDao {

	
	/*
	 * 通过帐号名字查找
	 */
	public Admin finByAdminName(String name){
		String sql = "select * from card where name = ?";
		return DbHelp.query(sql, new BeanHandler<Admin>(Admin.class), name);
	}
}
