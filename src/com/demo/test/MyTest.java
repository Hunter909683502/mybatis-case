package com.demo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.demo.model.User;

public class MyTest {
	/**
	 * 
	 * <p>Title: main</p>  
	 * <p>Description: 
	 * 	SqlSessionFactoryBuilder用于创建SqlSessionFacoty，SqlSessionFacoty一旦创建完成就不需要SqlSessionFactoryBuilder了，
	 *  因为SqlSession是通过SqlSessionFactory生产，所以可以将SqlSessionFactoryBuilder当成一个工具类使用，最佳使用范围是方法范围即方法体内局部变量。
	 *  
	 *  SqlSessionFactory是一个接口，接口中定义了openSession的不同重载方法，
	 *  SqlSessionFactory的最佳使用范围是整个应用运行期间，一旦创建后可以重复使用，通常以单例模式管理SqlSessionFactory。
	 *  
	 *  SqlSession是一个面向用户的接口， sqlSession中定义了数据库操作方法。
		每个线程都应该有它自己的SqlSession实例。SqlSession的实例不能共享使用，它也是线程不安全的。因此最佳的范围是请求或方法范围。
		绝对不能将SqlSession实例的引用放在一个类的静态字段或实例字段中。
		打开一个 SqlSession；使用完毕就要关闭它。通常把这个关闭操作放到 finally 块中以确保每次都能执行关闭。
	 * </p>  
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		
		//1、加载配置文件
		// Resources,这个类在 org.mybatis.io 包中。Resources 类正 如其名,会帮助你从类路径下, 文件系统或一个 web URL 加载资源文件。
		// Resources 是一个静态类，主要用于加载配置文件
		InputStream in = Resources.getResourceAsStream("mybatis.xml");
		//2、构建会话工厂，会话的概念可以简单的认为相当于JDBC中的Connection 
		// 注意：每个数据库对应一个 SqlSessionFactory 实例 
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		//创建回话对象, SqlSession 会话对象在Mybatis中是一个非常强大的类（目前这样理解就够）
		SqlSession session = factory.openSession();
		
		//查询
		List<User> list = session.selectList("getAllUser");
		
		/**
		 * log4j:WARN No appenders could be found for logger (org.apache.ibatis.logging.LogFactory).
		   log4j:WARN Please initialize the log4j system properly.
		   log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
		   
		   出现上面的信息说明缺少log4j的配置文件
		 
		日志信息：
		DEBUG [main] - Logging initialized using 'class org.apache.ibatis.logging.slf4j.Slf4jImpl' adapter.
		DEBUG [main] - PooledDataSource forcefully closed/removed all connections.
		DEBUG [main] - PooledDataSource forcefully closed/removed all connections.
		DEBUG [main] - PooledDataSource forcefully closed/removed all connections.
		DEBUG [main] - PooledDataSource forcefully closed/removed all connections.
		打开连接
		DEBUG [main] - Opening JDBC Connection
		创建连接
		DEBUG [main] - Created connection 1551870003.
		自动事务提交 为false，也就是默认事务提交是关闭的
		DEBUG [main] - Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@5c7fa833]
		执行sql语句
		DEBUG [main] - ==>  Preparing: select user_id userId, username, age, password from user; 
		没有参数
		DEBUG [main] - ==> Parameters: 
		查询结果为3条记录
		DEBUG [main] - <==      Total: 3
		
		从上面的日志中，我们可以看出，并没有让连接回到连接池的提示信息,那是因为没有关闭session
		 */
		
		//关闭session，注意如果是增删改操作的话，在这之前还要进行事务手动提交
		session.close();
		/**
		 * 关闭session之后
		 *  DEBUG [main] - Resetting autocommit to true on JDBC Connection [com.mysql.jdbc.JDBC4Connection@5c7fa833]
		 *  关闭连接
			DEBUG [main] - Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@5c7fa833]
			让连接返回连接池
			DEBUG [main] - Returned connection 1551870003 to pool.
		 */
		
		for (User user : list) {
			System.out.println(user);
		}
		/** 输出；
		 *  User [userId=1, username=张三丰, age=90, password=111111]
			User [userId=2, username=张无忌, age=30, password=222222]
			User [userId=3, username=张翠山, age=50, password=111111]
		 */
		
	}
	

}
