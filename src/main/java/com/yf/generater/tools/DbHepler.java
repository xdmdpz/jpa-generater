package com.yf.generater.tools;

import com.mi.packageManagement.velocity.entity.DataColumn;
import com.mi.packageManagement.velocity.entity.DataRow;
import com.mi.packageManagement.velocity.entity.DataTable;
import com.mi.packageManagement.velocity.utils.Contants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHepler {
    /**
     * 数据库连接对象
     */
    private Connection _CONN = null;


    /**
     * 获取数据库连接对象
     *
     * @param sUser 数据库账号
     * @param sPwd  数据库密码
     * @return
     */
    private boolean GetConn(String sUser, String sPwd) {
        if (_CONN != null) return true;
        try {
            Class.forName(Contants.JDBC_DRIVER);
            _CONN = DriverManager.getConnection(Contants.JDBC_URL, sUser, sPwd);
        } catch (Exception ex) {
            // ex.printStackTrace();
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    /**
     * sUser 数据库账号
     * sPwd  数据库密码
     *
     * @return
     */
    private boolean GetConn() {
        return GetConn(Contants.JDBC_USERNAME, Contants.JDBC_PASSWORD);
    }

    private void CloseConn() {
        try {
            _CONN.close();
            _CONN = null;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            _CONN = null;
        }
    }

    public boolean TestConn() {
        if (!GetConn())
            return false;

        CloseConn();
        return true;
    }

    public ResultSet GetResultSet(String sSQL, Object[] objParams) {
        GetConn();
        ResultSet rs = null;
        try {
            PreparedStatement ps = _CONN.prepareStatement(sSQL);
            if (objParams != null) {
                for (int i = 0; i < objParams.length; i++) {
                    ps.setObject(i + 1, objParams[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            CloseConn();
        } finally {
            //CloseConn();
        }
        return rs;
    }

    public Object GetSingle(String sSQL, Object... objParams) {
        GetConn();
        try {
            PreparedStatement ps = _CONN.prepareStatement(sSQL);
            if (objParams != null) {
                for (int i = 0; i < objParams.length; i++) {
                    ps.setObject(i + 1, objParams[i]);
                }
            }
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return rs.getString(1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            CloseConn();
        }
        return null;
    }

    public DataTable GetDataTable(String sSQL, Object... objParams) {
        GetConn();
        DataTable dt = null;
        try {
            PreparedStatement ps = _CONN.prepareStatement(sSQL);
            if (objParams != null) {
                for (int i = 0; i < objParams.length; i++) {
                    ps.setObject(i + 1, objParams[i]);
                }
            }
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            List<DataRow> row = new ArrayList<DataRow>();
            List<DataColumn> col = null;
            DataRow r = null;
            DataColumn c = null;

            String columnName;
            Object value;
            int iRowCount = 0;
            while (rs.next()) {
                iRowCount++;
                col = new ArrayList<DataColumn>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    columnName = rsmd.getColumnName(i);
                    value = rs.getObject(columnName);
                    c = new DataColumn(columnName, value);
                    col.add(c);
                }
                r = new DataRow(col);
                row.add(r);
            }
            dt = new DataTable(row);
            dt.RowCount = iRowCount;
            dt.ColumnCount = rsmd.getColumnCount();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            CloseConn();
        }
        return dt;
    }

    public int UpdateData(String sSQL, Object[] objParams) {
        GetConn();
        int iResult = 0;

        try {
            PreparedStatement ps = _CONN.prepareStatement(sSQL);
            if (objParams != null) {
                for (int i = 0; i < objParams.length; i++) {
                    ps.setObject(i + 1, objParams[i]);
                }
            }
            iResult = ps.executeUpdate(sSQL);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        } finally {
            CloseConn();
        }
        return iResult;
    }
}
