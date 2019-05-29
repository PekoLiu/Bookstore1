package dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtils;

public class BaseDao {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	//通用增删改
	//表和增删改语法  sql
	//赋值参数的个数和类型不一样
	public int executeUpdate(String sql,Object...params ) {
		int rows = 0;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++) {
				ps.setObject(i+1, params[i]);
			}
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return rows;
	}
	
	
	//通用查询
	//表和增删改语法  sql
	//赋值参数的个数和类型不一样
	public<T> List<T> executeQuery(String sql,Class<T> clz,Object...params){
		List<T> lists = new ArrayList<T>();
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++) {
				ps.setObject(i+1, params[i]);
			}
			rs = ps.executeQuery();
			
			//询问rs(rs的元数据:解释数据的数据)
			ResultSetMetaData md = rs.getMetaData();
			//获取列的个数
			int count = md.getColumnCount();
			
			while(rs.next()) {//每次遍历一行,创建一个对象()
				T t = clz.newInstance();  //调用无参构造
				for(int i=0;i<count;i++) {
					//1.获取列的名称
					String name = md.getColumnName(i+1);
					//2.获取列值
					Object value = rs.getObject(name);
					//3.获取同名属性
					Field field = clz.getDeclaredField(name);
					//4.属性赋值
					field.setAccessible(true);
					if(value != null) {
						field.set(t, value);
					}
				}
				lists.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return lists;
	}
	
}
