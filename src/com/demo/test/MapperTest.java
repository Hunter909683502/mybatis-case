package com.demo.test;

import java.util.HashMap;
import java.util.List;

import com.demo.model.Items;
import com.demo.service.ItemsService;
import com.demo.service.impl.ItemsServiceImpl;

public class MapperTest {
	
	public static void main(String[] args) throws Exception {
		ItemsService itemsService = new ItemsServiceImpl();
//		Items item = itemsService.getItemById(1);
//		
//		System.out.println(item);
		
		//Items vo = new Items();
		//vo.setItemsName("p");
		//vo.setPrice(10000);
		//List<Items> items = itemsService.getItemsByMultiConditions(vo);
//		for (Items t : items) {
//			System.out.println(t);
//		}
		
		HashMap<String, Object> vo = new HashMap<>();
		//vo.put("itemsName", "p");
		vo.put("price",10000.0);

		//测试反射实现的多条件查询
		List<Items> items = itemsService.getItemsByMultiConditions(Items.class, vo);
		for (Items t : items) {
			System.out.println(t);
		}
	}
	
}
