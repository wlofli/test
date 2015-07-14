package com.wolf.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/*
	 * 获取上X月的第一天00:00:00时间
	 * param:x //上X个月 0为当月
	 * 返回时间戳
	 */
	public static Long getMinMonthTime(int x){
		x = -x;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, x);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
//		System.out.println(calendar);
//		System.out.println(calendar.getTimeInMillis());
//		System.out.println(new Timestamp(calendar.getTimeInMillis()));
		return calendar.getTimeInMillis();
	}
	
	
	/**
	 * add by lzc
	 * date: 2015年7月14日
	 * @param date
	 * @return 24小时后的时间
	 */
	public static Date getNextDay(Date date){
		Calendar  calendar =Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.DAY_OF_YEAR, 1);
		return calendar.getTime();
		
	}

}
