package com.demo.dao;

import java.util.List;

import com.demo.model.User;
import com.demo.vo.UserVo;

public interface UserDao {
	public User getUserById(int id);
	public List<User> getUserByLikeUsername(String username);
	public User getUserByUsernameAndId(User user);
	public User addUser(User user);
	/**
	 * 
	 * <p>Title: deleteUser</p>  
	 * <p>Description: 
	 * 		删除单个用户
	 * 		
	 * </p>  
	 * @param user 要删除的用户
	 */
	public void deleteUser(User user);
	/**
	 * 
	 * <p>Title: deleteBatchUser</p>  
	 * <p>Description:
	 * 		批量删除多个用户信息
	 *  </p>  
	 * @param users 要删除的用户列表
	 */
	public void deleteBatchUser(UserVo uv);
	
	/**
	 * 
	 * <p>Title: updateUser</p>  
	 * <p>Description: 
	 * 		修改用户信息
	 * </p>  
	 * @param user 要更新的用户信息
	 */
	public void updateUser(User user);
	
	public List<User> getAllUserAboutOrders();
}
