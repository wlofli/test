package com.wolf.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Random;

/**
 * author lzc
 */
public class StringUtil {
	public static int getLength(String string) {
		return string.length();
	}
	
	
	/**
	 * 首字母大写
	 * add by lzc 2016年5月18日
	 * @param s
	 * @return
	 */
	public static String UpperCaseFirstLetter(String s) throws Exception{
		if(s == null || s.equals("")){
			throw new Exception("字符串为空");
		}
		Character a = s.charAt(0);
		String reString = Character.toString(Character.toUpperCase(a)) + s.substring(1, s.length());
		return reString;
	}
	
	
	public static String string2Unicode(String s) {
	    try {
	      StringBuffer out = new StringBuffer("");
	      byte[] bytes = s.getBytes("unicode");
	      for (int i = 2; i < bytes.length - 1; i += 2) {
	        out.append("u");
	        String str = Integer.toHexString(bytes[i + 1] & 0xff);
	        for (int j = str.length(); j < 2; j++) {
	          out.append("0");
	        }
	        String str1 = Integer.toHexString(bytes[i] & 0xff);

	        out.append(str);
	        out.append(str1);
	        out.append(" ");
	      }
	      return out.toString().toUpperCase();
	    }
	    catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	      return null;
	    }
	  } 

	 

	public static String unicode2String(String unicodeStr){
	    StringBuffer sb = new StringBuffer();
	    String str[] = unicodeStr.toUpperCase().split("U");
	    for(int i=0;i<str.length;i++){
	      if(str[i].equals("")) continue;
	      char c = (char)Integer.parseInt(str[i].trim(),16);
	      sb.append(c);
	    }
	    return sb.toString();
	  }
	
	/**将字符串里的大写字母替换为_小写字母   
	 * <result column="papersNumber" property="papersNumber" />
	 * -> <result column="papers_number" property="papersNumber" />
	 * add by lzc     date: 2015年10月8日
	 * @param s
	 * @return
	 */
	public static String mybaitsUpperCaseTo_LowerCase(String s){
		s.replaceAll("^[A-Z]", "\1[A-Z]");
		return s;
	}
	
	/**changgeCode
	 * add by lzc     date: 2015年10月26日
	 * @param s
	 * @param typeCode  (ex.GBK)
	 * @param targetCode (ex.UTF-8)
	 * @return
	 * @throws IOException
	 * 常用编码格式 
	 * ISO-8859-1
	 * GBK
	 * GB2312
	 * UTF-8
	 * BIG5//台湾繁体字编码
	 */
	public static String ChangeCode(String s, String typeCode, String targetCode) throws IOException{
		String result = null;
		try {
			result =  new String(s.getBytes(typeCode), targetCode);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new IOException();
		}
		return result;
	}
	
	
	/**字母是否大写
	 * add by lzc     date: 2015年10月30日
	 * @param c
	 * @return
	 */
	public static boolean isUpperCase(char c) {
		// TODO Auto-generated method stub
		if (Character.isUpperCase(c)) {
			return true;
		}
		return false;
	}
	
	public static boolean isEmpty(Object str) {
		return (str == null || "".equals(str));
	}

	
	 public static String getRandomString(int length){  
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
        Random random = new Random();  
        StringBuffer sb = new StringBuffer();  
          
        for(int i = 0 ; i < length; ++i){  
            int number = random.nextInt(62);//[0,62)  
              
            sb.append(str.charAt(number));  
        }  
        return sb.toString();  
    }  
	      
    public static String getRandomString2(int length){  
        Random random = new Random();  
          
        StringBuffer sb = new StringBuffer();  
          
        for(int i = 0; i < length; ++i){  
            int number = random.nextInt(3);  
            long result = 0;  
              
            switch(number){  
            case 0:  
                result = Math.round(Math.random() * 25 + 65);  
                sb.append(String.valueOf((char)result));  
                break;  
            case 1:  
                result = Math.round(Math.random() * 25 + 97);  
                sb.append(String.valueOf((char)result));  
                break;  
            case 2:  
                sb.append(String.valueOf(new Random().nextInt(10)));  
                break;  
            }  
        }  
        return sb.toString();     
    }  
	
	
	public static void main(String[] args) {
		String string = "u60A8u7684u9A8Cu8BC1u7801u662FuFF1Au3010u65B0u8D8Au7F51u3011u3002u5982u9700u5E2Eu52A9u8BF7u8054u7CFBu5BA2u670Du3002";
		try {
			String string2 = StringUtil.unicode2String(string);
//			String string2 = StringUtil.ChangeCode(string, "unicode", "UTF-8");
			System.out.println(string2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
