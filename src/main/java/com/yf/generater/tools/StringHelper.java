package com.yf.generater.tools;

public class StringHelper {
	/**
	 * 
	 * @Title: toFirstCharUpperCase
	 * @Description: 首字符大写
	 * @param @param str
	 * @param @return   
	 * @return String
	 * @throws
	 */
	public static String toFirstCharUpperCase(String name) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return name;
	}
	/**
	 * 
	 * @Title: toEntityClassName 
	 * @Description: 该方法将参数格式如t_user转换为User
	 * @param @param tableName 格式如：t_user
	 * @param @return    
	 * @return String
	 * @throws
	 */
	public static String toEntityClassName(String tableName){
		String result = "";
		if(tableName.indexOf("_")>-1){
			String[] ts = tableName.split("_");
			for (int i = 0; i < ts.length; i++) {
				String t = ts[i];
				if("t".equals(t)){
					//忽略
				}else{
					result = result + toFirstCharUpperCase(t);
				}
			}
		}
		return result;
	}
	/**
	 * 该方法将参数格式如t_user转换为user
	 * @param tableName
	 * @return
	 */
	public static String toRequestMappingName(String tableName) {
		String result = "";
		if(tableName.indexOf("_")>-1){
			String[] ts = tableName.split("_");
			for (int i = 0; i < ts.length; i++) {
				String t = ts[i];
				if("t".equals(t)){
					//忽略
				}else{
					if(i==1){
						result = t;
					}else{
						result = result + toFirstCharUpperCase(t);
					}
				}
			}
		}
		return result;
	}
}
