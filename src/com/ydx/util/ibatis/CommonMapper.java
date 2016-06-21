package com.ydx.util.ibatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * add by lzc 2016年6月17日
 * contact <coushuxiaolang@163.com>
 */

public interface CommonMapper {
	
	public List<Tables> exexSql(@Param("sql")String sql);

}
