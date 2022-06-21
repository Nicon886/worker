package com.oracle.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DBUtilsPro {
	private static DataSource dataSource;
	
	static {

		try {
			InputStream in = new FileInputStream("druid.properties");
			Properties p = new Properties();
			//���������ļ����Զ���ȡ�Ĵ����,����ͨ������Դ�������Ӷ���
			p.load(in);
			dataSource=DruidDataSourceFactory.createDataSource(p);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//��������Դ����
	public static DataSource getDataSource() {
			return dataSource;
		}
	
	//ͨ�����ݿ����ӳأ���������
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	/**
	 * �رս����
	 * 
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * �ر�Ԥ�������
	 * 
	 * @param ps
	 */
	public static void closePreparedStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * �ر����ӣ��黹���Ӹ����ӳ�
	 * 
	 * @param conn
	 */
	public static void closeConnnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * �����ͷŲ�ѯ����Դ
	 * 
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		closeResultSet(rs);
		closePreparedStatement(ps);
		closeConnnection(conn);
	}

	/**
	 * �����ͷ���ɾ�ĵ���Դ
	 * 
	 * @param conn
	 * @param ps
	 */
	public static void close(Connection conn, PreparedStatement ps) {

		closePreparedStatement(ps);
		closeConnnection(conn);
	}
}
