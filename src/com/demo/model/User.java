package com.demo.model;

import java.io.Serializable;
import java.util.List;
/**
 * 

* <p>Title: User</p>  

* <p>Description: User 实体类
* 	实体类是一个JavaBean ，以下是JavaBean的规范：
* 
* 	<li>1、实现Serializable 接口</li>
* 	<li>2、JavaBean提供一个无参构造器。</li>
* 	<li>3、提供成员变量getter、setter方法</li>
* 	<li>4、必须是一个公共类，将其访问属性设置为public</li>
* 	<li>5、所有属性变量都应该是private的</li>
* 	
*   为什么有这样的规范？
*   	1、为什么要实现Serializable接口？
*   		简单可以理解为便于网络传输就行。
*   	2、为什么要提供无参构造器呢？
*   		个人理解为理由有2点：
*   		a、在反射是创建对象，调用的是无参构造函数，这也是很多框架应用的。
*   		b、在继承时，JVM创建父类对象也是调用无参构造器来实现的。
*   	3、为了对象的信息的封装隐藏。
*   		
* </p>  
* 
* @author Hunter_1 
* @date 2018年7月15日
 */
public class User implements Serializable{
	
	private Integer userId;
	private String username;
	private int age;
	private String password;
	
	private List<Orders> orders;
	
	
	
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", age=" + age + ", password=" + password
				+ ", orders=" + orders + "]";
	}
	
}
