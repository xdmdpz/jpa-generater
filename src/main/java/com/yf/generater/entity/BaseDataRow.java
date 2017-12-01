package com.yf.generater.entity;

import java.io.Serializable;

public class BaseDataRow implements Serializable{
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = -6622967944036145346L;
	/**
	 * 列名
	 */
	private String columnName;
	/**
	 * 列名首字符大写名称
	 */
	private String columnNameII;
	/**
	 * 表名带下划线
	 */
	private String table_name= "";
	/**
	 * 数据库名带下划线
	 */
	private String db_name= "";
	/**
	 * 主键名带下划线
	 */
	private String id_name = "";
	/**
	 * 列名带下划线
	 */
	private String column_name= "";
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 长度
	 */
	private int length;
	/**
	 * 是否可空（1:可为空;0:不可为空）
	 */
	private int isNullAble;
	/**
	 * 注释
	 */
	private String desc;
	/**
	 * 是否主键（1:是;0:否）
	 */
	private int isPk;

	public int getIsPk() {
		return isPk;
	}

	public void setIsPk(int isPk) {
		this.isPk = isPk;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnNameII() {
		return columnNameII;
	}
	public void setColumnNameII(String columnNameII) {
		this.columnNameII = columnNameII;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getIsNullAble() {
		return isNullAble;
	}
	public void setIsNullAble(int isNullAble) {
		this.isNullAble = isNullAble;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getDb_name() {
		return db_name;
	}

	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}

	public String getId_name() {
		return id_name;
	}

	public void setId_name(String id_name) {
		this.id_name = id_name;
	}

	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
}
