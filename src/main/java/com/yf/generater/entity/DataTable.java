package com.yf.generater.entity;



import com.yf.generater.tools.StringHelper;

import java.util.ArrayList;
import java.util.List;

public class DataTable {
    List<DataRow> row;

    public DataTable() {
    }

    public DataTable(List<DataRow> _row) {
        this.row = _row;
    }

    public List<DataRow> GetRow() {
        return row;
    }

    public void SetRow(List<DataRow> _row) {
        row = _row;
    }

    public static void PrintTable(DataTable dt) {
        for (DataRow r : dt.GetRow()) {
            for (DataColumn c : r.GetColumn()) {
                System.out.print(c.GetKey() + ":" + c.GetValue() + "  ");
            }
            System.out.println("");
        }
    }

    public static List<BaseDataRow> ConvertDataTableToList(DataTable dt) {
        List<BaseDataRow> list = null;
        if (dt.RowCount > 0) {
            list = new ArrayList<BaseDataRow>();
            for (DataRow r : dt.GetRow()) {
                BaseDataRow row = new BaseDataRow();
                for (DataColumn c : r.GetColumn()) {
                    //System.out.print(c.GetKey() + ":" + c.GetValue() + "  ");
                    String key = c.GetKey();
                    if ("ColumnName".equals(key)) {
                        row.setColumnName(StringHelper.underlineToCamel(c.GetValue().toString()));
                        //转换首字符大写
                        row.setColumnNameII(StringHelper.toFirstCharUpperCase(StringHelper.underlineToCamel(c.GetValue().toString())));
                        row.setColumn_name(c.GetValue().toString());

                    }
                    if ("Type".equals(key)) {
                        //类型
                        String v = c.GetValue().toString();
                        if ("int".equals(v) || "smallint".equals(v) || "tinyint".equals(v)) {
                            row.setType("Integer");
                        } else if ("varchar".equals(v) || "text".equals(v) || "nvarchar".equals(v)) {
                            row.setType("String");
                        } else if ("datetime".equals(v) || "datetime2".equals(v) || "date".equals(v)) {
                            /*row.setType("Date");*/
                            row.setType("String");
                        } else if ("decimal".equals(v) || "float".equals(v) || "numeric".equals(v)) {
                            row.setType("Double");
                        } else if ("bigint".equals(v)) {
                            row.setType("Long");
                        }
                    }
                    if ("Length".equals(key)) {
                        try {
                            //长度
                            row.setLength(Integer.parseInt(c.GetValue().toString()));
                        } catch (Exception e) {
                            row.setLength(0);
                        }
                    }
                    if ("IsNullAble".equals(key)) {
                        try {
                            //可否为空( 0、不允许; 1、允许)
                            row.setIsNullAble(Integer.parseInt(c.GetValue().toString()));
                        } catch (Exception e) {
                            row.setIsNullAble(1);
                        }
                    }
                    if ("Description".equals(key)) {
                        //字段说明
                        if (c.GetValue() != null) {
                            row.setDesc("//" + c.GetValue().toString());
                        } else {
                            row.setDesc("//");
                        }
                    }

                    if ("ColumnKey".equals(key)) {
                        //字段说明
                        try {
                            if (c.GetValue().equals("PRI")) {
                                row.setIsPk(1);

                            } else {
                                row.setIsPk(0);
                            }
                        } catch (Exception e) {
                            row.setIsPk(0);

                        }
                    }

                    if ("DbName".equals(key)) {
                        if (c.GetValue() != null) {
                            row.setDb_name(c.GetValue().toString());
                        }
                    }
                    if ("TableName".equals(key)) {
                        if (c.GetValue() != null) {
                            row.setTable_name(c.GetValue().toString());
                        }
                    }
                }
                if(row.getIsPk() == 1)
                    row.setId_name(row.getColumn_name());
                list.add(row);
            }
        }
        return list;
    }

    public static int RowCount = 0;
    public static int ColumnCount = 0;
}
