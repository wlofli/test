package base.wolf.test;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.http.HTTPException;

import wolf.tools.WebApplication.HttpURLConnection;
import wolf.tools.WebApplication.UrlConnectionUtil;


/**
 * author lzc2015年7月23日上午11:27:52
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
		
		
		String uri = "http://192.168.8.23:8080/xinyue-server-webapp";
		Map<String,Object> map = new HashMap<String,Object>();
		 map.put("username","张三");
         map.put("password","88888");
         try {
			UrlConnectionUtil.doGet(uri, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	
	
	
	
}
