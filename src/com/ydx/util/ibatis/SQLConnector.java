package com.ydx.util.ibatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.text.StrBuilder;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.config.SpringConfig;

/**
 * add by lzc 2016年6月1日
 * contact <coushuxiaolang@163.com>
 */
public class SQLConnector {
	
	private static String url = "";
	private static String username = "";
	private static String password = "";
	
	
	/**
	 * 
	 * add by lzc 2016年6月17日
	 * @return
	 * @throws SQLException
	 */
	public Connection getYdxConnection() throws SQLException{
		
		return (Connection) DriverManager.getConnection(url, username, password);
	}
	
	
	
//	public SqlSessionFactory getFactory(){
//		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//		builder.build(config);
//	}
	
	public static void main(String[] args) {
		SpringConfig.start();
		
//		CommonMapper mapper = (CommonMapper) SpringConfig.applicationContext.getBean("commonMapper");
//		StrBuilder sb = new StrBuilder();
//		sb.append(" SHOW COLUMNS FROM ");
//		sb.append("goods_info");//tablename
//		System.out.println(sb.toString());
		CommonService commonService = (CommonService) SpringConfig.applicationContext.getBean("commonService");
		String string = "goods_info";
		List<Tables> list =  commonService.getTables(string);
		for (Tables tables : list) {
			System.out.println(tables.getField());
			
		}
	}
}
