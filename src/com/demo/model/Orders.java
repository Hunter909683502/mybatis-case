package com.demo.model;

import java.io.Serializable;

public class Orders implements Serializable{
	private Integer orderId;
	private Integer count;
	private Integer status;
	
	private User user;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", count=" + count + ", status=" + status + ", user=" + user + "]";
	}
	
}
