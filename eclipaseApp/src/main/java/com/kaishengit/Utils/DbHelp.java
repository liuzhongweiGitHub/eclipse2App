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
* @Description: ������
* @author: ����ΰ 
* @date: 2016��11��23�� ����8:33:56 
* @version 1.0
* 
*/

public class DbHelp {

	/**
	 * 
	 * @Description:ִ����ɾ��
	 * @author: ����ΰ
	 * @param sql
	 * @param params
	 * @return:void
	 * @time:2016��11��23�� ����9:35:51
	 */
	public static void update(String sql,Object...params) throws DateException{
		//��Ҫ�õ�apache��commons��ܵ�DbUtils�����QueryRunner��
		QueryRunner queryRunner = new QueryRunner();
		Connection conn = ConnectionManager.getConnection();
		try {
			queryRunner.update(conn, sql, params);
		} catch (SQLException e) {//��Щ���ݿ��쳣��������ͱ������ˣ���һ����֪��������ˣ�������Ҫ�׸���һ����ת��������ʱ�쳣�׸���һ�������ջ��ܵ�����������ǿ�Ʋ���ֻ�д���Ż���ִ���ҳ��
			e.printStackTrace();
			throw new DateException("sql:" + sql +"���ִ���",e);//��ɷ�����ʱ�쳣������
		} finally {
			try {
				DbUtils.close(conn);//�����dbutils����DbUtils��ķ���
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DateException("conn�رմ���",e);
			}
		}
	}
	
	/**
	 * 
	 * @Description:ִ�в�ѯ��������ѯ���ϣ�ʹ��commons-dbutils��
	 * @author: ����ΰ
	 * @param sql
	 * @param rs
	 * @param params
	 * @return
	 * @return:T
	 * @time:2016��11��23�� ����9:47:32
	 */
	public static <T> T query (String sql,ResultSetHandler<T> rs,Object...params) throws DateException{
		
		Connection conn = ConnectionManager.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		
		try {//���t�ǿ��԰������ؼ��ϵ�
			T t = queryRunner.query(conn, sql, rs, params);
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DateException("sql:" + sql +"���ִ���",e);
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DateException("conn�رմ���",e);
			}
		}
		//return null;�����쳣�ͷ����쳣������null��
	}
	
	
	
}
