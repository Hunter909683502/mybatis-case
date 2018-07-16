package com.demo.utils;

public class StringUtil {
	
	/**
	 * 
	 * <p>Title: toTitle</p>  
	 * <p>Description: 将首字母变大写</p>  
	 * @param str
	 * @return
	 */
	public static String toTitle(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	
}
