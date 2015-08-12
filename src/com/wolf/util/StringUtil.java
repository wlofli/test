package com.wolf.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * author lzc
 */
public class StringUtil {
	public static int getLength(String string) {
		return string.length();
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

	
	
	public static void main(String[] args) {
//		String string = "\u60A8\u7684\u9A8C\u8BC1\u7801\u662F\uFF1A\u3010% \u65B0\u8D8A\u7F51\u3011\u3002\u5982\u9700\u5E2E\u52A9\u8BF7\u8054\u7CFB\u5BA2\u670D\u3002";
//		System.out.println(StringUtil.unicode2String(string));
		String string = "您的验证码是：【% 新越网】。如需帮助请联系客服。";
		
		System.out.println(string);
		
	}
}
