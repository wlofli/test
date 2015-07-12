package com.wolf.util;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;


public  class MathUtil {
	public static float getPercent(int sum, int suc){
		if(sum == 0 || suc == 0){
			return 0;
		}
		return (float)suc / (float)sum;
	}
	
}
