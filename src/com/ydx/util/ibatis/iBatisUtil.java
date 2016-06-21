package com.ydx.util.ibatis;

import java.util.List;

import com.spring.config.SpringConfig;
import com.wolf.util.FileUtil;
import com.wolf.util.StringUtil;

/**
 * add by lzc 2016年5月18日
 * contact <coushuxiaolang@163.com>
 */
public class iBatisUtil {

	
	
	/**
	 * 
	 * add by lzc 2016年5月24日
	 * @param param
	 * @param filePath
	 * @param fileName
	 * @param tbName
	 * @param sel
	 * @param update
	 * @param insert
	 */
	public static void generateIbatisXml(String param, 
			String filePath, String fileName, String tbName,
			boolean sel, boolean update, boolean insert) {
		if(filePath == null){
			filePath = "d:test/";
		}
		
		if(fileName == null){
			fileName = "test.xml";
		}
		if (tbName == null) {
			tbName = "tb_test_info";
		}
		try {
			StringBuffer sb = new StringBuffer();
			addHead(sb,fileName);
			if(sel){
				addSel(sb,param,tbName);
			}
			if (insert) {
				sb.append("\n\n");
				addInsert(sb,param,tbName);
			}
			if(update){
				sb.append("\n\n");
				addUpdate(sb,param,tbName);
			}
			addEnd(sb);
		
			FileUtil.createFolder(filePath);
			FileUtil.write(filePath + fileName, sb.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	private static void addUpdate(StringBuffer sb, String param, String tbName) {
		// TODO Auto-generated method stub
		String[] list = param.split(",");
		sb.append("\t<update id=\"update\" parameterClass=\"hashMap\">\n");
		sb.append("\t\tUPDATE " + tbName + "\n");
		sb.append("\t\t<dynamic prepend=\"set\">\n");
		for (int i = 1; i < list.length; i++) {
			sb.append("\t\t\t<isNotNull prepend=\",\" property=\"" + list[i] + "\" > " + list[i] + " = #" +list[i] + "# </isNotNull>\n");
		}
		sb.append("\t\t</dynamic>\n");
		sb.append("\t\tWHERE " + list[0] + " = #" +list[0] + "#\n");
		sb.append("\t</update>");
	}


	private static void addInsert(StringBuffer sb, String param, String tbName) {
		// TODO Auto-generated method stub
		String[] list = param.split(",");
		sb.append("\t<insert id=\"insertSelective\" parameterClass=\"hashMap\">\n");
		sb.append("\t\tinsert into " + tbName + "\n");
		sb.append("\t\t<dynamic prepend=\"(\" >\n");
		for (int i = 0; i < list.length; i++) {
			sb.append("\t\t\t<isNotNull prepend=\",\" property=\"" + list[i] + "\" > "+ list[i] + " </isNotNull>\n");
		}
		sb.append("\t\t)\n");
		sb.append("\t\t</dynamic>\n");
		sb.append("\t\tvalues\n");
		
		sb.append("\t\t<dynamic prepend=\"(\" >\n");
		for (int i = 0; i < list.length; i++) {
			sb.append("\t\t\t<isNotNull prepend=\",\" property=\"" + list[i] + "\" > #"+ list[i] + "# </isNotNull>\n");
		}
		sb.append("\t\t)\n");
		sb.append("\t\t</dynamic>\n");
		sb.append("\t</insert>\n");
	}


	private static void addSel(StringBuffer sb, String param, String tbName) {
		// TODO Auto-generated method stub
		String []list = param.split(",");
		sb.append("\t<select id=\"select\" resultClass=\"java.util.HashMap\" parameterClass=\"hashMap\">\n");
		sb.append("\t\tSELECT ");
		for (int i = 0; i < list.length; i++) {
			if (i == list.length -1) {
				sb.append(list[i] + "\n");
			}else {
				sb.append(list[i] + ", ");
			}
		}
		sb.append("\t\tFROM " +tbName + "\n");
//		sb.append("\t\tWHERE " + list[0] + " = #" + list[0] + "#\n" );
		sb.append("\t\tLIMIT #_offset_#, #_size_#\n");
		sb.append("\t</select>\n\n");
		
		
		sb.append("\t<select id=\"select_size\" resultClass=\"string\" parameterClass=\"hashMap\">\n");
		sb.append("\t\tSELECT count(1) FROM " + tbName + "\n");
		sb.append("\t</select>\n");
		
	}


	private static void addEnd(StringBuffer sb) {
		// TODO Auto-generated method stub
		sb.append("\n</sqlMap>");
	}


	private static void addHead(StringBuffer sb, String fileName) throws Exception{
		// TODO Auto-generated method stub
		String string = fileName.split("\\.")[0];
		string = StringUtil.UpperCaseFirstLetter(string);
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		sb.append("<!DOCTYPE sqlMap PUBLIC \"-//ibatis.apache.org//DTD SQL Map 2.0//EN\" \"http://ibatis.apache.org/dtd/sql-map-2.dtd\" >\n");
		sb.append("<sqlMap namespace=\"" + string + "\" >\n");
	}


	public static void main(String[] args) {
//		String param = "goods_return_id,consignee,phone,tel,province_code,city_code,area_code,street_code,street_code,update_time,isdefault";
		StringBuffer sb = new StringBuffer();
		String tbname = null;
		String filePath = null;
		String fileName = null;
		SpringConfig.start();
		
		tbname = "tb_goods_return_info";
		fileName = "goods_return.xml";
		CommonService commonService = (CommonService) SpringConfig.applicationContext.getBean("commonService");
		List<Tables> list =  commonService.getTables(tbname);
		for (Tables tables : list) {
//			System.out.println(tables.getField());
			sb.append(tables.getField() + ",");
		}
		iBatisUtil.generateIbatisXml(sb.toString(), filePath, fileName, tbname, true, true, true);
	}
}
