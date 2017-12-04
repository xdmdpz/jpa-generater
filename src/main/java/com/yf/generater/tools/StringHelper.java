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
	//转变的依赖字符
	public static final char UNDERLINE='_';

	/**
	 * 将驼峰转换成"_"(userId:user_id)
	 * @param param
	 * @return
	 */
	public static String camelToUnderline(String param){
		if (param==null||"".equals(param.trim())){
			return "";
		}
		int len=param.length();
		StringBuilder sb=new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c=param.charAt(i);
			if (Character.isUpperCase(c)){
				sb.append(UNDERLINE);
				sb.append(Character.toLowerCase(c));
			}else{
				sb.append(c);
			}
		}
		return sb.toString();
	}
	/**
	 * 将"_"转成驼峰(user_id:userId)
	 * @param param
	 * @return
	 */
	public static String underlineToCamel(String param){
		if (param==null||"".equals(param.trim())){
			return "";
		}
		int len=param.length();
		StringBuilder sb=new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c=param.charAt(i);
			if (c==UNDERLINE){
				if (++i<len){
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			}else{
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
