package com.ydx.util.ibatis;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * add by lzc 2016年6月18日
 * contact <coushuxiaolang@163.com>
 */
@Service
public class CommonService {
	
	@Resource
	private CommonMapper commonMapper;
	
	public List<Tables> getTables(String name){
		return commonMapper.exexSql(name);
	}

}
