package base.wolf.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * author lzc2015年7月23日上午11:27:52
 */
public class Test {

	
	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.currentTimeMillis();
		Long time = Long.parseLong("1410243205000");
		Date date = new Date(time);
		System.out.println(simpleDateFormat.format(date));
	}
	
	
	
	
	
}
