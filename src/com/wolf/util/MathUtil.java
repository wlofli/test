package com.wolf.util;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;


public  class MathUtil {
	
	/**
	 * 
	 * add by lzc
	 * date: 2015年7月14日
	 * @param sum 分母
	 * @param suc 分子
	 * @return
	 */
	public static float getPercent(int sum, int suc){
		if(sum == 0 || suc == 0){
			return 0;
		}
		return (float)suc / (float)sum;
	}
	
}
