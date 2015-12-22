package wolf.baidu.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public class BaiduAPI {
	
	
	static String BAIDU_APPKEY = "aae9114c415375a24013688de2b527db";
	
	
	/**
	 * 身份查询
	 */
	static String  IDENTIFY_httpUrl = "http://apis.baidu.com/netpopo/idcard/query1";
	static String  IDENTIFY_httpArg = "idcard=330103199206132319";
											  

	/**
	 * MD5反编译
	 */
	static String  MD5_httpUrl = "http://apis.baidu.com/chazhao/md5decod/md5decod";
	static String  MD5_httpArg = "md5=b035b895aae7ea345897cac146a9eee3369c9ef1";

	/**身份证查询
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 * lastflag: 0true1false
	 * status
	 * 错误码	错误码返回	错误码返回说明
			300101	User's request is expired	用户请求过期
			300102	User call overrun per day	用户日调用量超限
			300103	Service call overrun per second	服务每秒调用量超限
			300104	Service call overrun per day	服务日调用量超限
			调用方错误：
			错误码	错误码返回	错误码返回说明
			300201	URL cannot be resolved	url无法解析
			300202	Missing apikey	请求缺少apikey，登录即可获取
			300203	Apikey or secretkey is NULL	服务没有取到apikey或secretkey
			300204	Apikey does not exist	apikey不存在
			300205	Api does not exist	api不存在
			300206	Api out of service	api已关闭服务
			300207	Service overdue, please pay in time	余额不足，请充值
			300208	User not verified	未通过实名验证
			300209	Service provider response status error	服务商响应status非200
			代理平台错误：
			错误码	错误码返回	错误码返回说明
			300301	Internal error	内部错误
			300302	Sorry,The system is busy. Please try again late	系统繁忙稍候再试
			城市查身份证接口调用方错误码：
			错误码	错误码返回	错误码返回说明
			201	身份证为空	无
			202	身份证不正确	无
			203	没有信息	无
			101	APPKEY为空或不存在	无
			102	APPKEY已过期	无
			103	APPKEY无请求此数据权限	无
			104	请求超过次数限制	无
			105	IP被禁止	无
			106	IP请求超过限制	无
			107	接口维护中	无
			108	接口已停用	无
			身份证查询接口调用方错误码：
			错误码	错误码返回	错误码返回说明
			201	身份证为空	无
			202	身份证不正确	无
			203	没有信息	无
			101	APPKEY为空或不存在	无
			102	APPKEY已过期	无
			103	APPKEY无请求此数据权限	无
			104	请求超过次数限制	无
			105	IP被禁止	无
			106	IP请求超过限制	无
			107	接口维护中	无
			108	接口已停用	无
	 * 
	 * 
	 * 
	 * 
	 */
	public static String identifySearch(String httpUrl, String httpArg) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        // 填入apikey到HTTP header
	        connection.setRequestProperty("apikey",  BAIDU_APPKEY);
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}


	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果  status:  0为正常返回
	 *  -1	md5密文错误	md5密文错误
	 *	-2	未找到匹配的md5解码	未找到匹配的md5解码
	 *  300301	Internal error	内部错误
	 *	300302	Sorry,The system is busy. Please try again late	系统繁忙稍候再试
	 * 
	 * 
	 */
	public static String MD5Search(String httpUrl, String httpArg) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        // 填入apikey到HTTP header
	        connection.setRequestProperty("apikey",  BAIDU_APPKEY);
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	
	public static void main(String[] args) {
		String httpArg = "idcard=110119120110119120";
		String re = BaiduAPI.identifySearch(IDENTIFY_httpUrl, IDENTIFY_httpArg);
		System.out.println(re);
		
		
		
//		String MD5SearchUrl = "http://apis.baidu.com/chazhao/md5decod/md5decod";
//		String MD5httpArg = "md5=C4CA4238A0B923820DCC509A6F75849B";
//		
//		String jsonResult = MD5Search(MD5SearchUrl, MD5httpArg);
//		System.out.println(jsonResult);
		
		
	}
	

}
