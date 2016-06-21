package com.ydx.util.ibatis;
/**
 * Model Object
 * add by lzc 2016年6月17日
 * contact <coushuxiaolang@163.com>
 */
public class Tables {
	private String Field;
	private String Type;
	private String Null;
	private String Default;
	private String Extra;
	private String Key;
	
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public String getField() {
		return Field;
	}
	public void setField(String field) {
		Field = field;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getNull() {
		return Null;
	}
	public void setNull(String null1) {
		Null = null1;
	}
	public String getDefault() {
		return Default;
	}
	public void setDefault(String default1) {
		Default = default1;
	}
	public String getExtra() {
		return Extra;
	}
	public void setExtra(String extra) {
		Extra = extra;
	}
	
	
	
}
