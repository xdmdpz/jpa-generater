package com.yf.generater;



import com.yf.generater.entity.DataColumn;
import com.yf.generater.entity.DataRow;
import com.yf.generater.entity.DataTable;
import com.yf.generater.tools.DbHepler;
import com.yf.generater.tools.VelocityHelper;
import com.yf.generater.utils.Contants;

import java.util.List;

public class DoGenerater {
    private static DbHepler helper = new DbHepler();

    /**
     * @param @param args   
     * @return void
     * @throws
     * @Title: main
     * @Description: 生成基础项目源码文件执行函数
     */
    public static void main(String[] args) {
        //查询数据库中所有表名称
        /*String sql_tableNames = "select name as '表名' from sys.tables";*/
        //for mysql
        String sql_tableNames = "select table_name from information_schema.tables where table_schema='" + Contants.GENERATE_DATABASENAME + "'";
        DataTable db_tableNames = helper.GetDataTable(sql_tableNames, null);
        int l_tableNames = db_tableNames.RowCount;
        System.out.println("在数据库中发现 " + l_tableNames + " 张表……");
        db_tableNames.PrintTable(db_tableNames);
        //表名列表
        List<DataRow> r_tableNames = db_tableNames.GetRow();
        for (DataRow r_tableName : r_tableNames) {
            for (DataColumn c_tableName : r_tableName.GetColumn()) {
                //表名
                String tableName = c_tableName.GetValue().toString();
                System.out.println("表名：" + tableName);
                //根据表名查询指定表的表结构信息
                //for sqlserver
                /*String sql_tableColumns = " SELECT a.name AS ColumnName, t.name AS Type, a.length AS Length, a.isnullable AS IsNullAble, cast(g.[value] as varchar(500)) AS Description "+
                                          " FROM "+
            							  " syscolumns a "+
            							  " LEFT JOIN systypes b ON a.xtype = b.xusertype "+
            							  " INNER JOIN sysobjects d ON a.id = d.id "+
            							  " AND d.xtype = 'U' "+
            							  " AND d.name <> 'dtproperties' "+
            							  " INNER JOIN systypes t ON a.xtype = t.xtype "+
            							  " LEFT JOIN sys.extended_properties g ON a.id = g.major_id "+
            							  " AND a.colid = g.minor_id "+
            							  " WHERE "+
            							  " d.[name] = '"+tableName+"' "+
            							  " ORDER BY a.id, a.colorder";*/
                //for mysql
                String sql_tableColumns = "select * from (select COLUMN_NAME as ColumnName," +
                        " DATA_TYPE as Type,IS_NULLABLE as IsNullAble, " +
                        " CHARACTER_MAXIMUM_LENGTH as Length,COLUMN_COMMENT as Description ," +
                        " COLUMN_KEY as ColumnKey ," +
                        " table_schema as DbName ," +
                        " table_name as TableName " +
                        "from information_schema.columns  where table_schema = '" + Contants.GENERATE_DATABASENAME + "' and table_name = '" + tableName +
                        "')k";

                DataTable db_tableColumns = helper.GetDataTable(sql_tableColumns, null);
                System.out.println(sql_tableColumns);
                int l_tableColumns = db_tableColumns.RowCount;
                System.out.println("------------------------------------------");
                System.out.println("");
                System.out.println("在表名 " + tableName + " 中发现 " + l_tableColumns + " 个字段……");
                db_tableColumns.PrintTable(db_tableColumns);

                try {
                    //自动生成实体类
                    (new VelocityHelper(tableName, db_tableColumns, Contants.GENERATE_CARBON + "/com/" + Contants.GENERATE_PROJECTNAME + "/entity", Contants.GENERATE_PROJECTNAME)).GenerateEntity();
                    //自动生成jpa接口文件
                    (new VelocityHelper(tableName, db_tableColumns, Contants.GENERATE_CARBON + "/com/" + Contants.GENERATE_PROJECTNAME + "/jpa", Contants.GENERATE_PROJECTNAME)).GenerateJpa();
                    //自动生成Service服务类文件
                    (new VelocityHelper(tableName, db_tableColumns, Contants.GENERATE_CARBON + "/com/" + Contants.GENERATE_PROJECTNAME + "/service", Contants.GENERATE_PROJECTNAME)).GenerateService();
                    //自动生成Controller控制类文件
                    (new VelocityHelper(tableName, db_tableColumns, Contants.GENERATE_CARBON + "/com/" + Contants.GENERATE_PROJECTNAME + "/controller", Contants.GENERATE_PROJECTNAME)).GenerateController();


                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
