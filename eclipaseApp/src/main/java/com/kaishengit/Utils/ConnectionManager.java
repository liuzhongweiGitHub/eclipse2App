/**
 * 
 */
package com.kaishengit.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.kaishengit.exception.DateException;

/** 
* @ClassName: ConnectionManager 
* @Description: 创建连接
* @author: 刘忠伟 
* @date: 2016年11月22日 下午10:51:08 
* @version 1.0
* 
*/

public class ConnectionManager {

	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql:///book";
	private static final String username = "root";
	private static final String password = "root";
	/**
	 * 
	 * @Description:创建连接
	 * @author: 刘忠伟
	 * @return
	 * @return:Connection
	 * @time:2016年11月22日 下午10:52:50
	 */
	public static Connection getConnection(){
		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DateException("conn错误",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DateException("conn关闭错误",e);
		}
	
		
	} 
}
