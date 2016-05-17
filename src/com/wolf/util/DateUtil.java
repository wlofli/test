package com.wolf.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/*
	 * 获取上X月的第一天00:00:00时间
	 * param:x //上X个月 0为当月
	 * 返回时间戳
	 * 2015年7月19日23:02:26
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
	
	/**获取当前时间前三个月的月初日子
	 * add by lzc     date: 2016年1月26日
	 * ex:
	 * now:2016年1月26日11:31:46
	 * @return 20151001
	 */
	public static int getLatst3MonthStartDate(){
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-3);
		calendar.set(Calendar.DAY_OF_MONTH,1);
//		System.out.println(df.format(calendar.getTime()).toString());
		
		
		return Integer.parseInt(df.format(calendar.getTime()).toString());
	}
	
	/**获取上个月月末日子
	 * add by lzc     date: 2016年1月26日
	 * ex:
	 * now:2016年1月26日11:33:14
	 * @return 20151231
	 */
	public static int getLastMonthEndDate(){
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DATE));
//		System.out.println(calendar.get(Calendar.MONTH));
//		System.out.println(df.format(calendar.getTime()).toString());
		return Integer.parseInt(df.format(calendar.getTime()).toString());
		
	}
	
	/**获取年份第一天
	 * add by lzc     date: 2016年1月29日
	 * @param year
	 * @return
	 */
	public static int getYearBeginDate(int year){
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH,0);
		calendar.set(Calendar.DAY_OF_MONTH,1);
//		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(df.format(calendar.getTime()).toString());
		return Integer.parseInt(df.format(calendar.getTime()).toString());
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
	
	
	public static Date getDate(String date, String format){
		
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
//			log.error("获取某格式的时间异常", e);
		}
		return null;
	}
	
	public static void main(String[] args) {
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(DateUtil.getDate("", format));
//		System.out.println(sf.format(new Date()));
//		System.out.println(sf.format(DateUtil.getNextDay(new Date())));
//		System.out.println(sf.format(DateUtil.getNextDay(new Date())));
//		System.out.println(sf.format(DateUtil.getMinMonthTime(1)));
//		System.out.println(sf.format(DateUtil.getMinMonthTime(2)));
//		System.out.println(sf.format(DateUtil.getMinMonthTime(3)));
		Date date = new Date();
		System.out.println(date.getTime()/1000);
		
	}

}
