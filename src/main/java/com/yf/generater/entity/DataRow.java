package com.yf.generater.entity;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

public class DataRow {
	List<DataColumn> col;
	public DataRow(List<DataColumn> _col)
	{
		col = _col;
	}
	
	public List<DataColumn> GetColumn()
	{
		return col;
	}
	
	public void SetColumn(List<DataColumn> _col)
	{
		col = _col;
	}
	
	public DataColumn GetColumn(String colName)
	{
		for(DataColumn c:col)
		{
			if(c.GetKey().toUpperCase().equals(colName.toUpperCase()))
			{
				try
				{
					return c;
				}catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}
		}
		
		return null;
	}
	
	public int GetColumnInt(String colName)
	{
		for(DataColumn c:col)
		{
			if(c.GetKey().toUpperCase().equals(colName.toUpperCase()))
			{
				try
				{
					return Integer.parseInt(c.GetValue().toString());
				}catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}
		}
		
		return 0;
	}
	
	public String GetColumnString(String colName)
	{
		for(DataColumn c:col)
		{
			if(c.GetKey().toUpperCase().equals(colName.toUpperCase()))
			{
				try
				{
					return c.GetValue().toString();
				}catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}
		}
		
		return "";
	}
	
	public Date GetColumnDate(String colName)
	{
		for(DataColumn c:col)
		{
			if(c.GetKey().toUpperCase().equals(colName.toUpperCase()))
			{
				try
				{
					return Date.valueOf(c.GetValue().toString());
				}catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}
		}
		
		return null;
	}
	
	public Blob GetColumnBlob(String colName)
	{
		for(DataColumn c:col)
		{
			if(c.GetKey().toUpperCase().equals(colName.toUpperCase()))
			{
				try
				{
					return (Blob)c.GetValue();
				}catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}
		}
		
		return null;
	}
	
	public float GetColumnFloat(String colName)
	{
		for(DataColumn c:col)
		{
			if(c.GetKey().toUpperCase().equals(colName.toUpperCase()))
			{
				try
				{
					return Float.parseFloat(c.GetValue().toString());
				}catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}
		}
		
		return 0;
	}

}
