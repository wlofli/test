package com.sixgroup.dyue.constutils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

	

public class FileIO {
	  public static void main(String[] args)  {
		  int b = 0;
		  FileReader in = null;
		  FileWriter out = null;
//			InputStreamReader isr=new InputStreamReader(new FileInputStream("d:/dy/1.jpg"),"UTF-8");
//			
//			FileWriter out2 = new FileWriter("d:/dy/5.jpg");
//			while ((b = isr.read()) != -1) {
//				out2.write(b);
//			}
//			out2.close();
		  
		  
		  StringBuffer stringBuffer = new StringBuffer();
		  try {
		    in = new FileReader("d:/dy/1.docx");
		    out = new FileWriter("d:/dy/4.docx");
		    
		    while((b=in.read())!=-1){
		      out.write(b);
		    }
		    out.close();
		    in.close(); 
		    
		  } catch (FileNotFoundException e2) {
		    System.out.println("找不到指定文件"); System.exit(-1);
		  } catch (IOException e1) {
		    System.out.println("文件复制错误"); System.exit(-1);
		  }
		  System.out.println("文件已复制");
	  }
			

}
