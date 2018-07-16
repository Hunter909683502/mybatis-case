package com.demo.test;

import java.util.List;

import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import com.demo.vo.UserVo;

/**
 *  为了方便查看报错信息，在这里就不用JUNIT测试啦
 * <p>Title: Test2</p>  
 * <p>Description: </p>  
 * @author Hunter_1 
 * @date 2018年7月15日
 */
public class Test2 {

	public static void main(String[] args) {
		UserService service = new UserServiceImpl();
//		User user = service.getUserById(1);
//		System.out.println(user);
		
//		List<User> users = service.getUserByLikeUsername("张");
//		for (User user : users) {
//			System.out.println(user);
//		}
//		User user = service.getUserByUsernameAndId("张翠山", 3);
//		System.out.println(user);
		
//		User vo = new User();
//		vo.setAge(30);
//		vo.setPassword("abc123");
//		vo.setUsername("张九阳");
//		service.addUser(vo);
//		System.out.println(vo);
		
//		User user = service.getUserByUsernameAndId("张九阳", 6);
//		service.deleteUser(user);
		
//		List<User> users = service.getUserByLikeUsername("九");
//		UserVo uv = new UserVo();
//		uv.setUsers(users);
//		service.deleteBatchUser(uv);
		
		User user = service.getUserByUsernameAndId("张翠山", 3);
		System.out.println("update=="+user);
		user.setUsername("张翠山-副本");
		service.updateUser(user);
	}
}
