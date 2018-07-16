package com.demo.service.impl;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.demo.dao.ItemsDao;
import com.demo.model.Items;
import com.demo.service.ItemsService;
import com.demo.utils.MybatisUtil;
import com.demo.utils.StringUtil;

/**
 * 测试mapper动态代理
 * <p>Title: ItemsServiceImpl</p>  
 * <p>Description: </p>  
 * @author Hunter_1 
 * @date 2018年7月16日
 */
public class ItemsServiceImpl implements ItemsService{

	@Override
	public Items getItemById(int id) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSessionFactory().openSession();
		
		ItemsDao proxy = session.getMapper(ItemsDao.class);
		
		Items item = proxy.getItemById(id);
		return item;
	}
	
	/**
	 * 总结一下：
	 * 		这里应用到了反射的知识，极大的减少代码量，否则的话会出现大量的if -- else语句来判断实现
	 * 
	 * 		同时涉及到HashMap的遍历，在这里推荐使用entrySet()的遍历方法，性能比较好
	 * 			vo.entrySet():获取到遍历key-value 集合
	 * 			set.getKey():获取到key
	 * 			set.getValue():获取到key对应的value
	 * 		
	 * 		反射：
	 * 			Class.forName(String):
	 * 				这里没有涉及到，但是还是要说明一下，根据类全名加载一个类对象从而获取对应的类字节码对象，会抛出异常
	 * 			clazz.newInstance():
	 * 				根据对应的字节码对象创建实例，这个是在反射中经常用的
	 * 			clazz.getMethod(methodName,...paraType):获取制定的方法；
	 * 				methodName:方法的名字
	 * 				paraType:不定参数，可以理解为数组，放的方法参数类型的字节码对象，如参数类型是String的话，对应的是String.class
	 * 			invoke(obj,...value):执行对应的方法，强调者是一个method对象，执行的就是method对象对应的方法
	 * 				obj:该方法属于哪个类下的，这是该类的实例
	 * 				value:执行该方法要传入的参数，多个参数传入要位置一一对应。
	 * 				
	 * 			
	 * 		重点强调：
	 * 			这个Class对象在反射中极为重要，个人认为是反射之源，无论你是获取类实例，还是类的属性，类相关的方法都是从这个字节码
	 * 			文件出发。推荐查看一下这个类JDK 的API
	 */
	public List<Items> getItemsByMultiConditions(Class clazz, HashMap<String,Object> vo) throws Exception{
		
		//首先遍历map 获取里边的条件名和值
		Set<Entry<String, Object>> entrySet = vo.entrySet();
		//反射创建一个对象
		Object object = clazz.newInstance();
		
		
		//反射实现
		for (Entry<String, Object> entry : entrySet) {
			//获取方法名
			String setterName = entry.getKey();
			//获取方法的参数
			Object setterValue = entry.getValue();
			//获取方法对象,在这里就可以发现一个问题就是，在定义属性的getter方法的时候，尽量使用包装类型
			Method met = clazz.getMethod("set"+StringUtil.toTitle(setterName), setterValue.getClass());
			//执行方法
			met.invoke(object, setterValue);
		}
		
		SqlSession session = MybatisUtil.getSessionFactory().openSession();
		ItemsDao proxy = session.getMapper(ItemsDao.class);
		
		List<Items> items = proxy.getItemsByMultiConditions((Items) object);
		
		session.close();
		
		return items;
		
	}

	@Override
	public List<Items> getItemsByMultiConditions(Items vo) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSessionFactory().openSession();
		ItemsDao proxy = session.getMapper(ItemsDao.class);
		
		List<Items> items = proxy.getItemsByMultiConditions(vo);
		
		session.close();
		
		return items;
	}
}
