package com.demo.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * <p>Title: MybatisUtil</p>  
 * <p>Description: 
 * 		
 * 	</p>  
 * 
 * @author Hunter_1 
 * @date 2018年7月15日
 */
public class MybatisUtil {
	/**
	 * <p>Title: getSession</p>  
	 * <p>Description:
	 * 		封装会话工厂的工具方法
	 *  </p>  
	 * @return
	 */
	public static SqlSessionFactory getSessionFactory() {

		InputStream in;
		try {
			in = Resources.getResourceAsStream("mybatis.xml");
			
			return new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
