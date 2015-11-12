package wolf.tools.WebApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public class MessageSender {
	
	static String account = "mkxiaoxiao";
	static String pwd     = "mk123456";
	
	static String serverUrl = "http://sms.106jiekou.com/utf8/sms.aspx?";
	
	
	
	
	
	
	public static void main(String[] args) throws IOException  {
		String content = "您的验证码是：【%新越网】。如需帮助请联系客服。";
		String phone  = "18768104912";
		// 短信内容说明
		String contents = content.replace("%", "rftx");

		// 内容编码转换
		String strTemp = URLEncoder.encode(contents, "UTF-8");
		String uri = serverUrl + "account=" + account + "&password=" + pwd + "&mobile=" + phone + "&content=" + strTemp;
//		System.out.println("content= " + content);
//		System.out.println("contents=" + contents);
//		System.out.println("strTemp = " + strTemp);
		System.out.println("uri= " + uri);
		BufferedReader in = null;
		try {
			URL url = new URL(uri);
			URLConnection con = url.openConnection();
			con.connect();
			
			String result = "";
			String line ;
			 in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			
			// 结果返回
			int i = 1;
			while ((line = in.readLine()) != null) {
				
				result += line;
				i++;
			}
			System.out.println("i = " + i);
			System.out.println("result = " + result);
			if (result.equals("100")) {
				System.out.println("发送成功");
			}else {
				System.out.println("发送失败");
			}
		} catch (MalformedURLException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 释放
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
//	100         发送成功
//
//	101         验证失败
//
//	102         手机号码格式不正确
//
//	103         会员级别不够
//
//	104         内容未审核
//
//	105         内容过多
//
//	106         账户余额不足
//
//	107         Ip受限
//
//	108         手机号码发送太频繁，请换号或隔天再发
//
//	109         帐号被锁定
//
//	110         手机号发送频率持续过高，黑名单屏蔽数日
//
//	  120         系统升级
	
	
	

}
