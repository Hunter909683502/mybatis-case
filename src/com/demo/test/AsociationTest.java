package com.demo.test;

import java.util.List;

import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;

public class AsociationTest {
	public static void main(String[] args) {
//		OrderService service = new OrderServiceImpl();
//		List<Orders> orders = service.getAllOrdersAndAboutUser();
//		
//		for (Orders orders2 : orders) {
//			System.out.println(orders2);
//		}
		
		UserService service = new UserServiceImpl();
		
		List<User> users = service.getAllUserAboutOrders();
		for (User user : users) {
			System.out.println(user);
		}
		
	}
}
