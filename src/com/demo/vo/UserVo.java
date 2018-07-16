package com.demo.vo;

import java.util.List;

import com.demo.model.User;

/**
 * user 值对象类
 * 由于mybatis是基于getter、setter获取参数、设置参数
 * 
 *快捷键： ctrl+O 查看类结构
 * <p>Title: UserVo</p>  
 * <p>Description: </p>  
 * @author Hunter_1 
 * @date 2018年7月15日
 */
public class UserVo {
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
