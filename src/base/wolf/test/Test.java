package base.wolf.test;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;



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
//		System.out.println(getPath());
		JSONObject object = new JSONObject();
		JSONObject object1 = new JSONObject();
		
		JSONArray array = new JSONArray();
		String text = "[{\"goods_id\":\"2\",\"history_type\":2,\"img\":\"group1/M00/00/06/wKgA_VddNnuAAESbAAAnRa4ZNJ0053.jpg\",\"isHistoryAllowEdit\":false,\"isHistorySelect\":false,\"main_sku_id\":\"1\",\"market_price\":300.0,\"qty\":2,\"rate\":0.0,\"sell_price\":200.0,\"shop_car_qty\":1,\"short_name\":\"天天酷跑\",\"sku_id\":\"2\",\"title\":\"杀杀杀\"},{\"goods_id\":\"2\",\"history_type\":2,\"img\":\"group1/M00/00/06/wKgA_VddNnuAAESbAAAnRa4ZNJ0053.jpg\",\"isHistoryAllowEdit\":false,\"isHistorySelect\":false,\"main_sku_id\":\"2\",\"market_price\":34.0,\"qty\":35,\"rate\":0.0,\"sell_price\":13.0,\"shop_car_qty\":1,\"short_name\":\"56\",\"sku_id\":\"42\",\"title\":\"杀杀杀\"},{\"goods_id\":\"4\",\"history_type\":2,\"img\":\"group1/M00/00/06/wKgA_VddNnuAAESbAAAnRa4ZNJ0053.jpg\",\"isHistoryAllowEdit\":false,\"isHistorySelect\":false,\"main_sku_id\":\"1\",\"market_price\":400.0,\"qty\":10,\"rate\":0.0,\"sell_price\":200.0,\"shop_car_qty\":1,\"short_name\":\"够丝滑巧克力\",\"sku_id\":\"124\",\"title\":\"巧克力\"}]";
		object.put("goods_id", "2");
		object.put("history_type", "2");
		object1.put("goods_id", "3");
		object1.put("history_type", "3");
		array.add(object);
		array.add(object1);
		
		
		System.out.println(array.toString());
		List<Map> list = array.parseArray(array.toString(), Map.class);
		for (Map map : list) {
			Map<String, String> map2 = map;
			System.out.println(map2.toString());
		}
//		JSONObject.parseObject("", Map.class);
		
		
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
