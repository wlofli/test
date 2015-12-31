package com.wolf.util;

import java.util.ArrayList;
import java.util.List;

/**
 * author lzc2015年7月29日下午3:07:41
 */
public class ListUtil {
	@SuppressWarnings("unchecked")
	public static <T, E> List<T> ArrayToList(E[] e) {
		List<T> tList = new ArrayList<T>();
		for (int i = 0; i < e.length; i++) {
			tList.add((T) e[i]);
		}
		return tList;
		
	}
	
	
	public static void main(String[] args) {
		String[] eString = {"1","2","3"};
		List<String> sList = ListUtil.ArrayToList(eString);
		System.out.println(sList);
		
	}
	

}
