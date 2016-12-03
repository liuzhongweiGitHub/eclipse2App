/**
 * 
 */
package com.kaishengit.Utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.kaishengit.exception.DateException;

/** 
* @ClassName: DbHelp 
* @Description: 工具类
* @author: 刘忠伟 
* @date: 2016年11月23日 上午8:33:56 
* @version 1.0
* 
*/

public class DbHelp {

	/**
	 * 
	 * @Description:执行增删改
	 * @author: 刘忠伟
	 * @param sql
	 * @param params
	 * @return:void
	 * @time:2016年11月23日 上午9:35:51
	 */
	public static void update(String sql,Object...params) throws DateException{
		//需要用的apache的commons框架的DbUtils里面的QueryRunner类
		QueryRunner queryRunner = new QueryRunner();
		Connection conn = ConnectionManager.getConnection();
		try {
			queryRunner.update(conn, sql, params);
		} catch (SQLException e) {//这些数据库异常，在这里就被捕获了，上一级不知道哪里错了，所以需要抛给上一级，转化成运行时异常抛给上一级，最终会跑到容器。不用强制捕获，只有错误才会出现错误页面
			e.printStackTrace();
			throw new DateException("sql:" + sql +"出现错误",e);//变成非运行时异常向上抛
		} finally {
			try {
				DbUtils.close(conn);//导入的dbutils包的DbUtils类的方法
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DateException("conn关闭错误",e);
			}
		}
	}
	
	/**
	 * 
	 * @Description:执行查询单个，查询集合，使用commons-dbutils包
	 * @author: 刘忠伟
	 * @param sql
	 * @param rs
	 * @param params
	 * @return
	 * @return:T
	 * @time:2016年11月23日 上午9:47:32
	 */
	public static <T> T query (String sql,ResultSetHandler<T> rs,Object...params) throws DateException{
		
		Connection conn = ConnectionManager.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		
		try {//这个t是可以包含返回集合的
			T t = queryRunner.query(conn, sql, rs, params);
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DateException("sql:" + sql +"出现错误",e);
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DateException("conn关闭错误",e);
			}
		}
		//return null;出现异常就返回异常，不用null了
	}
	
	
	
}
