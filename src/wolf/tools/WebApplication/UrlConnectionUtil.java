package wolf.tools.WebApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


import java.net.HttpURLConnection;


/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public class UrlConnectionUtil {
	    
	     private static final String SERVLET_POST = "POST" ;
	     private static final String SERVLET_GET = "GET" ;
	     private static final String SERVLET_DELETE = "DELETE" ;
	     private static final String SERVLET_PUT = "PUT" ;
	     
	     private static String prepareParam(Map<String,Object> paramMap){
	         StringBuffer sb = new StringBuffer();
	         if(paramMap.isEmpty()){
	             return "" ;
	         }else{
	             for(String key: paramMap.keySet()){
	                 String value = (String)paramMap.get(key);
	                 if(sb.length()<1){
	                     sb.append(key).append("=").append(value);
	                 }else{
	                     sb.append("&").append(key).append("=").append(value);
	                 }
	             }
	             return sb.toString();
	         }
	     }
	     
	     public static void  doPost(String urlStr,Map<String,Object> paramMap ) throws Exception{
	         URL url = new URL(urlStr);
	         HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	         conn.setRequestMethod(SERVLET_POST);
	         String paramStr = prepareParam(paramMap);
	         conn.setDoInput(true);
	         conn.setDoOutput(true);
	         OutputStream os = conn.getOutputStream();     
	         os.write(paramStr.toString().getBytes("utf-8"));     
	         os.close();         
	         
	         BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         String line ;
	         String result ="";
	         while( (line =br.readLine()) != null ){
	             result += "/n"+line;
	         }
	         System.out.println(result);
	         br.close();
	         
	     }
	     
	     public static void  doGet(String urlStr,Map<String,Object> paramMap ) throws Exception{
	         String paramStr = prepareParam(paramMap);
	         if(paramStr == null || paramStr.trim().length()<1){
	             
	         }else{
	             urlStr +="?"+paramStr;
	         }
	         System.out.println(urlStr);
	         URL url = new URL(urlStr);
	         HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	         conn.setRequestMethod(SERVLET_GET);
	         conn.setRequestProperty("Content-Type","text/html; charset=UTF-8");
	         
	         conn.connect();
	         BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         String line ;
	         String result ="";
	         while( (line =br.readLine()) != null ){
	             result += "/n"+line;
	         }
	         System.out.println(result);
	         br.close();
	     }
	     
	     public static void doPut(String urlStr,Map<String,Object> paramMap) throws Exception{
	         URL url = new URL(urlStr);
	         HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	         conn.setRequestMethod(SERVLET_PUT);
	         String paramStr = prepareParam(paramMap);
	         conn.setDoInput(true);
	         conn.setDoOutput(true);
	         OutputStream os = conn.getOutputStream();     
	         os.write(paramStr.toString().getBytes("utf-8"));     
	         os.close();         
	         
	         BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         String line ;
	         String result ="";
	         while( (line =br.readLine()) != null ){
	             result += "/n"+line;
	         }
	         System.out.println(result);
	         br.close();
	                 
	     }
	     
	     public static void doDelete(String urlStr,Map<String,Object> paramMap) throws Exception{
	         String paramStr = prepareParam(paramMap);
	         if(paramStr == null || paramStr.trim().length()<1){
	             
	         }else{
	             urlStr +="?"+paramStr;
	         }   
	         System.out.println(urlStr);
	         URL url = new URL(urlStr);
	         HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	         conn.setDoOutput(true);
	         conn.setRequestMethod(SERVLET_DELETE);
	         if(conn.getResponseCode() ==200){
	             System.out.println("成功");
	         }else{
	             System.out.println(conn.getResponseCode());
	         }
	     }
	     
	     
	     
	     public static void main(String[] args) throws Throwable {
//	    	 String url = "https://passport.58.com/mobileauthcodelogin/getcode";
//	    	 ?mobile=18768104912&validatecode=xkbh3&source=pc-login&callback=jsonp1449815255700&_=1449815408053"
	    	 
	    	 String url = "http://www.91loan.cn/moke/site/send/code";
	    	 UrlConnectionUtil coon = new UrlConnectionUtil();
	    	 Map<String, Object> map = new HashMap<String, Object>();
	    	 map.put("phone", "18768104912");
	    	 map.put("check", "false");
//	    	 map.put("validatecode", "xxxdy");
//	    	 map.put("source", "pc-login");
//	    	 map.put("callback", "jsonp1449815255704");
//	    	 map.put("_", "1449815865944");
	    	 coon.doPost(url, map);
			
		}
}
