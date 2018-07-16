package com.demo.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.demo.dao.OrderDao;
import com.demo.model.Orders;
import com.demo.service.OrderService;
import com.demo.utils.MybatisUtil;

public class OrderServiceImpl implements OrderService {

	@Override
	public List<Orders> getAllOrdersAndAboutUser() {
		SqlSession session = MybatisUtil.getSessionFactory().openSession();
		OrderDao proxy = session.getMapper(OrderDao.class);
		List<Orders> orders = proxy.getAllOrdersAndAboutUser();
		
		session.close();
		
		return orders;
	}

}
