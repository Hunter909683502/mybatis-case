package com.demo.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.demo.dao.UserDao;
import com.demo.dao.impl.UserDaoImpl;
import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.utils.MybatisUtil;
import com.demo.vo.UserVo;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	

	@Override
	public User getUserById(int id) {
		
		return userDao.getUserById(id);
	}

	@Override
	public List<User> getUserByLikeUsername(String username) {
		
		return userDao.getUserByLikeUsername(username);
	}

	@Override
	public User getUserByUsernameAndId(String username, int id) {
		
		User vo = new User();
		vo.setUserId(id);
		vo.setUsername(username);
		
		return userDao.getUserByUsernameAndId(vo);
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userDao.deleteUser(user);
	}

	@Override
	public void deleteBatchUser(UserVo uv) {
		// TODO Auto-generated method stub
		userDao.deleteBatchUser(uv);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}
	
	/**
	 * Mapper动态代理实现
	 */
	@Override
	public List<User> getAllUserAboutOrders() {
		
		SqlSession session = MybatisUtil.getSessionFactory().openSession();
		UserDao proxy = session.getMapper(UserDao.class);
		List<User> users = proxy.getAllUserAboutOrders();
		
		session.close();
		
		return users;
	}

}
