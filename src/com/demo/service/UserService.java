package com.demo.service;

import java.util.List;

import com.demo.model.User;
import com.demo.vo.UserVo;

public interface UserService {
	/**
	 * 
	 * <p>Title: getUserById</p>  
	 * <p>Description: 
	 * 		根据id获取user 如果不存在的话返回null
	 * </p>  
	 * @param id 要获取用户的id
	 * @return
	 */
	public User getUserById(int id);
	/**
	 * 
	 * <p>Title: getUserByLikeUsername</p>  
	 * <p>Description: 
	 * 		根据传入的username 查询用户，支持模糊查询
	 * </p>  
	 * @param username
	 * @return 返回含有username的用户列表
	 */
	public List<User> getUserByLikeUsername(String username);
	/**
	 * 
	 * <p>Title: getUserByUsernameAndId</p>  
	 * <p>Description: 
	 * 		根据username 和 id 获取制定用户，不存在返回null
	 * </p>  
	 * @param username
	 * @param id
	 * @return
	 */
	public User getUserByUsernameAndId(String username, int id);
	/**
	 * 
	 * <p>Title: addUser</p>  
	 * <p>Description:
	 * 		添加单个用户。
	 *  </p>  
	 * @param user 要添加的用户信息，但不包括id，因为id在本业务逻辑中属于自增长，不需要设置
	 * @return 返回添加成功的用户，这个时候返回的user对象因为 selectKey的order属性为AFTER ，已经设置好值啦
	 */
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
	 * @param uv包含了要删除的用户列表的值对象
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
	
	/**
	 * 
	 * <p>Title: getAllUserAboutOrders</p>  
	 * <p>Description:
	 * 	查询所有用户和相关的订单信息
	 * </p>  
	 * @return
	 */
	public List<User> getAllUserAboutOrders();
	
//	public void updateBatchUsers()
}	
