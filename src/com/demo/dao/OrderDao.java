package com.demo.dao;

import java.util.List;

import com.demo.model.Orders;

public interface OrderDao {
	public List<Orders> getAllOrdersAndAboutUser();
}
