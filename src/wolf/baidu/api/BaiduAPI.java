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
	 * ��ݲ�ѯ
	 */
	static String  IDENTIFY_httpUrl = "http://apis.baidu.com/netpopo/idcard/query1";
	static String  IDENTIFY_httpArg = "idcard=330103199206132319";
											  

	/**
	 * MD5������
	 */
	static String  MD5_httpUrl = "http://apis.baidu.com/chazhao/md5decod/md5decod";
	static String  MD5_httpArg = "md5=b035b895aae7ea345897cac146a9eee3369c9ef1";

	/**���֤��ѯ
	 * @param urlAll
	 *            :����ӿ�
	 * @param httpArg
	 *            :����
	 * @return ���ؽ��
	 * lastflag: 0true1false
	 * status
	 * ������	�����뷵��	�����뷵��˵��
			300101	User's request is expired	�û��������
			300102	User call overrun per day	�û��յ���������
			300103	Service call overrun per second	����ÿ�����������
			300104	Service call overrun per day	�����յ���������
			���÷�����
			������	�����뷵��	�����뷵��˵��
			300201	URL cannot be resolved	url�޷�����
			300202	Missing apikey	����ȱ��apikey����¼���ɻ�ȡ
			300203	Apikey or secretkey is NULL	����û��ȡ��apikey��secretkey
			300204	Apikey does not exist	apikey������
			300205	Api does not exist	api������
			300206	Api out of service	api�ѹرշ���
			300207	Service overdue, please pay in time	���㣬���ֵ
			300208	User not verified	δͨ��ʵ����֤
			300209	Service provider response status error	��������Ӧstatus��200
			����ƽ̨����
			������	�����뷵��	�����뷵��˵��
			300301	Internal error	�ڲ�����
			300302	Sorry,The system is busy. Please try again late	ϵͳ��æ�Ժ�����
			���в����֤�ӿڵ��÷������룺
			������	�����뷵��	�����뷵��˵��
			201	���֤Ϊ��	��
			202	���֤����ȷ	��
			203	û����Ϣ	��
			101	APPKEYΪ�ջ򲻴���	��
			102	APPKEY�ѹ���	��
			103	APPKEY�����������Ȩ��	��
			104	���󳬹���������	��
			105	IP����ֹ	��
			106	IP���󳬹�����	��
			107	�ӿ�ά����	��
			108	�ӿ���ͣ��	��
			���֤��ѯ�ӿڵ��÷������룺
			������	�����뷵��	�����뷵��˵��
			201	���֤Ϊ��	��
			202	���֤����ȷ	��
			203	û����Ϣ	��
			101	APPKEYΪ�ջ򲻴���	��
			102	APPKEY�ѹ���	��
			103	APPKEY�����������Ȩ��	��
			104	���󳬹���������	��
			105	IP����ֹ	��
			106	IP���󳬹�����	��
			107	�ӿ�ά����	��
			108	�ӿ���ͣ��	��
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
	        // ����apikey��HTTP header
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
	 *            :����ӿ�
	 * @param httpArg
	 *            :����
	 * @return ���ؽ��  status:  0Ϊ��������
	 *  -1	md5���Ĵ���	md5���Ĵ���
	 *	-2	δ�ҵ�ƥ���md5����	δ�ҵ�ƥ���md5����
	 *  300301	Internal error	�ڲ�����
	 *	300302	Sorry,The system is busy. Please try again late	ϵͳ��æ�Ժ�����
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
	        // ����apikey��HTTP header
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
