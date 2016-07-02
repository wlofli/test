package com.wolf.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import sun.security.provider.MD5;

import com.thoughtworks.xstream.XStream;

/**
 * author lzc
 * 2016年6月22日下午5:29:06
 */

public class Weixin {
	private static String key = "1234";
	
	//必填:
	private String appid;//应用id 
	
	private String mch_id;//商户号
	
	private String body;//商品描述
	
	private String order_trade_no;//商户订单号
	
	private Integer total_fee;//总金额
	
	private String spbill_create_ip;//终端IP
	
	private String notify_url;//通知地址
	
	private String trade_type;//交易类型
	
	private String nonce_str;//随机字符串
	
	private String sign;//签名
	
	//非必填:
	
	private String device_id;//设备号
	
	private String detail;//商品详情
	
	private String attach;//附加数据
	
	private String fee_type;//货币类型 默认人民币：CNY
	
	private String time_start;//交易起始时间
	
	private String time_expire;//交易结束时间
	
	private String goods_tag;//商品标记
	
	private String limit_pay;//指定支付方式

	
	
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOrder_trade_no() {
		return order_trade_no;
	}

	public void setOrder_trade_no(String order_trade_no) {
		this.order_trade_no = order_trade_no;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getLimit_pay() {
		return limit_pay;
	}

	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}
	
	
	/**
	 * 设置随机数
	 * add by lzc
	 * date: 2016年6月22日
	 * @param weixin
	 * @return
	 */
	public static Weixin getRandomString(Weixin weixin){  
	    int length = 32;
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
	    Random random = new Random();  
	    StringBuffer sb = new StringBuffer();  
	    for(int i = 0 ; i < length; ++i){  
	        int number = random.nextInt(62);//[0,62)  
	        sb.append(str.charAt(number));  
        }  
        weixin.setNonce_str(sb.toString());  
        return weixin;
	}
	
	//签名
	public static Weixin sign(Weixin weixin){
		try {
			StringBuilder sb = new StringBuilder();
			TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
//			Class clz = weixin.getClass();
			Field[] fields = Weixin.class.getFields();
			for (int i = 0; i < fields.length; i++) {
				treeMap.put(fields[i].getName(), fields[i].get(weixin));
			}
			Set<String> keySet = treeMap.keySet();
			Iterator<String> it = keySet.iterator();
			boolean isFirst = true;
			while (it.hasNext()) {
				String key = it.next();
				if(treeMap.get(key) != null){
					if(!isFirst){
						sb.append("&");
					}else {
						isFirst = false;
					}
					sb.append(key + "=" + treeMap.get(key));
				}
			}
			sb.append("&key = "+ Weixin.key);
			weixin.setSign(MD5Util.MD5(sb.toString()).toUpperCase());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return weixin;
	}

	
	public static Object mapToObject(Map map,Class<?> clz){
		Field field[] = clz.getDeclaredFields();
			try {
				Object object = clz.newInstance();
				List<Field> list = Arrays.asList(field);
				for (Field field2 : list) {
					if(map.get(field2.getName())!= null){
						field2.set(object, map.get(field2.getName()));
					}
				}
//				BeanUtils.populate(object, map);
				return object;
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		return null;
	}
	

	
//	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
//		TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
//		Weixin weixin = new Weixin();
//		weixin.setBody("booooody");
//		weixin.setDetail("dettaiillll");
//		Class clz = weixin.getClass();
//		Field[] fields = clz.getDeclaredFields();
//		
//		for (int i = 0; i < fields.length; i++) {
//			System.out.println(fields[i].getName());
//			treeMap.put(fields[i].getName(), fields[i].get(weixin));
//		}
//		Set<String> keySet = treeMap.keySet();
//		Iterator<String> it = keySet.iterator();
//		while (it.hasNext()) {
//			String key = it.next();
//			if (treeMap.get(key)!=null) {
//				System.out.println(treeMap.get(key));
//			}
//			System.out.println(key);
//		}
//		System.out.println(fields.length);
//	}
}
