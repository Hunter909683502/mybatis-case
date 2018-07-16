package com.demo.service;

import java.util.List;

import com.demo.model.Orders;

public interface OrderService {
	
	/**
	 * 
	 * <p>Title: getAllOrdersAndAboutUser</p>  
	 * <p>Description: 
	 * 		获取所有的订单和订单相关的用户信息
	 * </p>  
	 * @return 
	 */
	public List<Orders> getAllOrdersAndAboutUser();
}
