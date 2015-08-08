package com.wolf.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/*
	 * 获取上X月的第一天00:00:00时间
	 * param:x //上X个月 0为当月
	 * 返回时间戳
	 * 2015年7月19日23:02:26
	 * 下月以后再次测试->undone 未测试
	 * 
	 */
	public static Long getMinMonthTime(int x){
		Calendar calendar = Calendar.getInstance();
//		System.out.println(calendar.get(Calendar.YEAR));
//		System.out.println(calendar.get(Calendar.MARCH));
//		System.out.println(calendar.get(Calendar.MONTH));
//		System.out.println(calendar.get(Calendar.DATE));
//		System.out.println(calendar.get(Calendar.MINUTE));
		
		calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH) - x);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
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
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		return calendar.getTime();
		
	}
	
	
	public static void main(String[] args) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println(sf.format(new Date()));
		System.out.println(sf.format(DateUtil.getNextDay(new Date())));
//		System.out.println(sf.format(DateUtil.getMinMonthTime(0)));
//		System.out.println(sf.format(DateUtil.getMinMonthTime(1)));
//		System.out.println(sf.format(DateUtil.getMinMonthTime(2)));
//		System.out.println(sf.format(DateUtil.getMinMonthTime(3)));
		
	}

}
