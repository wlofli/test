package com.wolf.util;
/**
 * author lzc
 */

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MyBatisUtil {
	public static void main(String[] args) {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		String genCfg = "E:/git/test/resource/properties/generatorConfig.xml"; //src的一级目录下
//System.out.println("E:/git/test/resource/properties/generatorConfig.xml");
//		File configFile = new File(MyBatisUtil.class.getResource(genCfg).getFile());
		File configFile = new File(genCfg);
System.out.println("configFile = " + configFile);
		ConfigurationParser cp = new ConfigurationParser(warnings);
System.out.println("cp = " + cp);
		Configuration config = null;
		try {
			config = cp.parseConfiguration(configFile);
System.out.println("config = " + config);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
System.out.println("myBatisGenerator = " + myBatisGenerator);
			//执行语句
			myBatisGenerator.generate(null);
System.out.println("ok");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
	
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}