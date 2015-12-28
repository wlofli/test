package base.wolf.test;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.xml.ws.http.HTTPException;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.jdbc.SqlRunner;
import org.apache.tomcat.jni.User;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.internal.db.ConnectionFactory;

import com.wolf.util.MD5Util;
import com.wolf.util.StringUtil;

import base.wolf.model.BaseModel;
import wolf.tools.WebApplication.UrlConnectionUtil;


/**
 * author lzc2015年7月23日11:27:52
 */
public class Test {

	
	public static void main(String[] args) throws IOException,HTTPException {

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
		
		
		//number
//		 NumberFormat nf = new DecimalFormat("######0.00");
//		System.out.println(nf.format(Double.parseDouble("6")));
//		System.out.println();
		
		
//		//out of memory
//		List<double[]> parent = new ArrayList<double[]>();
//		for (int i = 0; i < 100000; i++) {
////			for (int j = 0; j < 10000; j++) {
//				double[] child = new double[10000];
//				parent.add(child);
//				child = null;
//				System.out.println(parent.size());
////			}
//		}
		
		//uri simulator
//		String uri = "http://192.168.8.23:8080/xinyue-server-webapp";
//		Map<String,Object> map = new HashMap<String,Object>();
//		 map.put("username","张三");
//         map.put("password","88888");
//         try {
//			UrlConnectionUtil.doGet(uri, map);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		String tString = "&18768104912&123456";
//		System.out.println(tString.split("&").length);
//		http://www.91loan.cn/moke/site/send/code?check=false
//		data,	phone 
//		type:json
		
		
		
		//随机产生八位数
//		Random random = new Random();
//		for (int i = 0; i < 100; i++) {
//			int k =  random.nextInt(100000000);
//			System.out.println(String.format("%08d", k));
//		}
		
		
		
		
		
		
//		JDBCConnectionConfiguration config = new JDBCConnectionConfiguration();
//		try {
//			ConnectionFactory.getInstance().getConnection(config );
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Connection connection = null;
//		SqlRunner runner = new SqlRunner(connection);
		
		DecimalFormat df = new DecimalFormat("######0.00");
		
		double a = Double.parseDouble(df.format(6.021565456));
		System.out.println(a);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


	
	
	
	
	
}
