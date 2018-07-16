package com.demo.service;

import java.util.HashMap;
import java.util.List;

import com.demo.model.Items;

public interface ItemsService {
	public Items getItemById(int id);
	/**
	 * 实现多条件动态查询
	 * <p>Title: getItemsByMultiConditions</p>  
	 * <p>Description:
	 * 		动态条件查询，也称不定条件查询，每次查询的条件个数的不固定的。
	 * 		没有条件的话在vo对象中，该条件就是null
	 *  </p>  
	 * @param vo 封装了查询条件的vo对象,string 对应的是条件名，Object对应的是该条件下的值, clazz 就是要查询的对象类型
	 * @return 
	 * @throws Exception 
	 */
	public List<Items> getItemsByMultiConditions(Class clazz, HashMap<String,Object> vo) throws Exception;
	
	/**
	 * 实现多条件动态查询
	 * <p>Title: getItemsByMultiConditions</p>  
	 * <p>Description:
	 * 		动态条件查询，也称不定条件查询，每次查询的条件个数的不固定的。
	 * 		没有条件的话在vo对象中，该条件就是null
	 *  </p>  
	 * @param vo 封装了查询条件的vo对象,为了简化实现，将条件封装在Items对象中
	 * @return 
	 */
	public List<Items> getItemsByMultiConditions(Items vo);
}
