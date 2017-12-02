package com.yf.generater.utils;

/**
 * Created by if on 2017/12/1.
 */
public class Contants {
    public static final String GENERATE_SUFFIX_ENTITY = ".java";
    public static final String GENERATE_SUFFIX_SERVICE = "Service.java";
    public static final String GENERATE_SUFFIX_JPA = "Repository.java";
    public static final String GENERATE_SUFFIX_CONTROLLER = "Controller.java";


    //副本目录
    public static final String GENERATE_CARBON = "/carbon";
    //项目别名
    public static final String GENERATE_PROJECTNAME = "yf.core";
    //数据库名称
    public static final  String GENERATE_DATABASENAME = "jpagenerater";

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD = "123";
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/"+GENERATE_DATABASENAME+"?useUnicode=true&characterEncoding=utf-8";




}
