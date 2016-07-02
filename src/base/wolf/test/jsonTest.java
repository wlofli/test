package base.wolf.test;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.formula.functions.T;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wolf.util.Weixin;

/**
 * author lzc
 * 2016年6月29日下午7:01:59
 */
public class jsonTest {

	
	public static Object mapToObject(Map map,Class<?> clz){
			Field field[] = clz.getDeclaredFields();
			try {
				Object object = clz.newInstance();
				List<Field> list = Arrays.asList(field);
				AccessibleObject.setAccessible(field, true);
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
	
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Map map = new HashMap();
		map.put("body", "body");
		map.put("appid", "123456");
		map.put("total_fee", 55555);
		map.put("totototo", true);
		Weixin weixin = (Weixin) mapToObject(map, Weixin.class );
		System.out.println(weixin.getBody());
		System.out.println(weixin.getAttach());
		System.out.println(weixin.getAppid());
		System.out.println(weixin.getTotal_fee());
		
	}
}
