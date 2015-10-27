package base.wolf.test;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * author lzc2015年7月23日上午11:27:52
 */
public class Test {

	
	public static void main(String[] args) {

//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSSZ");
//		System.currentTimeMillis();
//		Long time = Long.parseLong("1410243205000");
//		Date date = new Date(System.currentTimeMillis());
//		System.out.println(simpleDateFormat.format(date));
//		System.out.println(String.format("%,d",9999999));
//		System.out.println("test");
//		System.out.println(System.currentTimeMillis());
		
		
		
//		HashMap<String, String>map = new HashMap<String, String>();
//		map.put("id", "id");
//		System.out.println(map.get("name"));
//		String string = "%3CCOUNTRY%3E/%3CLANG%3E";
		
//		LocalDateTime localDateTime = LocalDateTime.now();
//		System.out.println(localDateTime);
		
		
//		 NumberFormat nf = new DecimalFormat("######0.00");
//		System.out.println(nf.format(Double.parseDouble("6")));
//		int tint = 257;
//		char ch = '=';
//		boolean s = true;
//		byte a = 3;
//		byte b = (byte) tint;
//		System.out.println();
		
		
		
		String s = "//杩欎釜绫伙紝涓轰簡鎬ц兘浼樺寲鍋氫簡寰堝鐗瑰埆澶勭悊锛屼竴鍒囬兘鏄负浜嗘�ц兘锛侊紒锛�";
		String t;
		try {
			t = new String(s.getBytes("GBK"),"UTF-8");
			System.out.println(t);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
	
	
	
}
