package base.wolf.test;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.mail.internet.InternetAddress;
import javax.xml.ws.http.HTTPException;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.jdbc.SqlRunner;
import org.apache.tomcat.jni.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.internal.db.ConnectionFactory;
import org.springframework.data.redis.connection.Message;

import com.wolf.util.FileUtil;
import com.wolf.util.MD5Util;
import com.wolf.util.StringUtil;

import base.wolf.model.BaseModel;
import base.wolf.struct.Tree;
import wolf.tools.WebApplication.UrlConnectionUtil;


/**
 * author lzc2015年7月23日11:27:52
 */
public class Test {

	public static String getPath(){
		String result = Test.class.getResource("/").toString();
		System.out.println(result);
		int s = result.indexOf("classes");
		result = result.subSequence(5, s).toString();
//		result = result.substring(s);
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(getPath());
		
		Map maps = new HashMap();
		Iterator it =maps.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			if (maps.get(key) instanceof String) {
				
			}else {
				
			}
			Double value = (Double) maps.get(key);
			
		}
//		maps.entrySet();
//		System.out.println(tString);
		
//		FileUtil.write(test.getPath()+"txt.txt", "111");
		
		
//		InetAddress address = InetAddress.getLocalHost();
//		System.out.println(InetAddress.getLocalHost());

//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSSZ");
//		System.currentTimeMillis();
//		Long time = Long.parseLong("1410243205000");
//		Date date = new Date(System.currentTimeMillis());
//		System.out.println(simpleDateFormat.format(date));
//		System.out.println(String.format("%,d",9999999));
//		System.out.println("test");
//		System.out.println(System.currentTimeMillis());
		
		
		
		
//		number
		 NumberFormat nf = new DecimalFormat("######0.00");
		System.out.println(nf.format(Double.parseDouble("6")));
		System.out.println();
		
		
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
		
//		DecimalFormat df = new DecimalFormat("######0.00");
//		
//		double a = Double.parseDouble(df.format(6.021565456));
//		System.out.println(a);
		
		
		
		
	}


	
		
	
	
	
}
