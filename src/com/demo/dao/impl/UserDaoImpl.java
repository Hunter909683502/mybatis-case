package com.demo.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.demo.dao.UserDao;
import com.demo.model.User;
import com.demo.utils.MybatisUtil;
import com.demo.vo.UserVo;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSessionFactory().openSession();
		
		return session.selectOne("getUserById", id);
	}

	@Override
	public List<User> getUserByLikeUsername(String username) {
		
		SqlSession session = MybatisUtil.getSessionFactory().openSession();
		return session.selectList("getUserByLikeUsername", username);
	}

	@Override
	public User getUserByUsernameAndId(User user) {
		SqlSession session = MybatisUtil.getSessionFactory().openSession();
		
		return session.selectOne("getUserByUsernameAndId", user);
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSessionFactory().openSession();
		session.insert("addUser",user);
		
		//手动提交事务
		session.commit();
		session.close();//记得关闭session
		
//		System.out.println("Dao--"+user);
		
		return user;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSessionFactory().openSession();
		session.delete("deleteUser",user);
		
		//暂时不提交事务
		session.commit();
		session.close();
	}

	@Override
	public void deleteBatchUser(UserVo uv) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSessionFactory().openSession();
		session.delete("deleteBatchUser",uv);
		
		session.commit();
		session.close();
	}

	@Override
	public void updateUser(User user) {
		SqlSession session = MybatisUtil.getSessionFactory().openSession();
		session.update("updateUser",user);
		
		session.commit();
		session.close();
	}
	
	/**
	 * 这里通过mapper动态代理实现啦，无效
	 */
	@Deprecated
	public List<User> getAllUserAboutOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
