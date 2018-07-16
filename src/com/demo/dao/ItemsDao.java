package com.demo.dao;

import java.util.List;

import com.demo.model.Items;

public interface ItemsDao {
	public Items getItemById(int id);
	public List<Items> getItemsByMultiConditions(Items vo);
}
