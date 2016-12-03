/**
 * 
 */
package com.kaishengit.entity;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kaishengit.Utils.DbHelp;

/** 
* @ClassName: AdminDao 
* @Description: 
* @author: ����ΰ 
* @date: 2016��11��22�� ����10:46:10 
* @version 1.0
* 
*/

public class AdminDao {

	
	/*
	 * ͨ���ʺ����ֲ���
	 */
	public Admin finByAdminName(String name){
		String sql = "select * from card where name = ?";
		return DbHelp.query(sql, new BeanHandler<Admin>(Admin.class), name);
	}
}
