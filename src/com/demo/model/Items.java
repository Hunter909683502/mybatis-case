package com.demo.model;

import java.io.Serializable;

/***
 * 
 * <p>Title: Items</p>  
 * <p>Description: 
 * 		商品JavaBean
 * </p> 
 * <p>Tip: 
 * 		个人发现在为了实现更加好扩展代码的时候，基本类型应该较少使用，而是使用对应的包装类型
 * 		这样是使用反射的时候，才更加便利。
 * </p> 
 * @author Hunter_1 
 * @date 2018年7月16日
 */
public class Items implements Serializable{
	private Integer itemsId;
	private String itemsName;
	private Double price;
	public Integer getItemsId() {
		return itemsId;
	}
	public void setItemsId(Integer itemsId) {
		this.itemsId = itemsId;
	}
	public String getItemsName() {
		return itemsName;
	}
	public void setItemsName(String itemsName) {
		this.itemsName = itemsName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Items [itemsId=" + itemsId + ", itemsName=" + itemsName + ", price=" + price + "]";
	}
	
}
