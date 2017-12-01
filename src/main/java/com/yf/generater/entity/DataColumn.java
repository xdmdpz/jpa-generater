package com.yf.generater.entity;

public class DataColumn {
	String key;
	Object value;
	
	public DataColumn(String _key,Object _value)
	{
		key = _key;
		value = _value;
	}
	
	public String GetKey()
	{
		return key;
	}
	
	public Object GetValue()
	{
		return value;
	}
	
	public void SetKey(String _key)
	{
		key = _key;
	}
	
	public void SetValue(Object _value)
	{
		value = _value;
	}
}
