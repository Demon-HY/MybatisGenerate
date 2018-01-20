package com.demon.mybatis.generator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Types;
import java.util.Objects;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * 字符串处理工具类
 */
public class StringUtils {

    /**
     * 获得类首字母小写
     */
    public static String getClassLower(String className) {
        return className.substring(0, 1).toLowerCase() + className.substring(1);
    }

    /**
     * 获得类首字母大写
     */
    public static String getClassUpper(String className) {
        return className.substring(0, 1).toUpperCase() + className.substring(1);
    }

    /**
     * 获得set 方法
     */
    public static String getSetMethod(String field) {
        String methodStr = "";

        methodStr = "set";

        if ((field == null) || (field == "")) {
            return "";
        } else {
            field = methodStr + field.substring(0, 1).toUpperCase()
                    + field.substring(1);

            return field;
        }
    }

    /**
     * 获得get 方法
     */
    public static String getGetMethod(String field) {
        String methodStr;

        methodStr = "get";

        if ((field == null) || (Objects.equals(field, ""))) {
            return "";
        } else {
            field = methodStr + field.substring(0, 1).toUpperCase() + field.substring(1);

            return field;
        }
    }

    /**
     * 去掉下划线，将下划线后首字母大写
     */
    public static String getDomainColumnName(String databaseColumn) {
        if ((databaseColumn == null) || (Objects.equals(databaseColumn, ""))) {
            return "";
        } else {
            int _postion = -1;
            while (databaseColumn.indexOf("_") > 0) {
                _postion = databaseColumn.indexOf("_");
                if (_postion < databaseColumn.length() - 1) {
                    databaseColumn = databaseColumn.substring(0, _postion)
                            + databaseColumn.substring(_postion + 1,
                            _postion + 2).toUpperCase()
                            + databaseColumn.substring(_postion + 2,
                            databaseColumn.length());
                } else {
                    databaseColumn = databaseColumn.replace("_", "");
                }
            }
        }

        return databaseColumn;
    }

    public static String getFieldType(int databaseType) {
        String colType = "";

        switch (databaseType) {
            case java.sql.Types.DECIMAL:
            case java.sql.Types.REAL:
                colType = "Double";
                break;
            case java.sql.Types.INTEGER:
            case java.sql.Types.BIGINT:
            case java.sql.Types.TINYINT:
            case java.sql.Types.SMALLINT:
                colType = "Integer";
                break;
            case java.sql.Types.VARCHAR:
            case java.sql.Types.CHAR:
            case java.sql.Types.LONGVARBINARY:
            case java.sql.Types.LONGVARCHAR:
                colType = "String";
                break;
            case java.sql.Types.DATE:
            case java.sql.Types.TIMESTAMP:
                colType="Date";
                break;
            case Types.BIT:
                colType="Boolean";
                break;
            default:
                System.out.println("找不到数据类型："+databaseType);
                break;
        }

        return colType;
    }

    public static String getColumnType(int databaseType) {
        switch (databaseType) {
            case java.sql.Types.DECIMAL:
                return "DECIMAL";
            case java.sql.Types.REAL:
                return "REAL";
            case java.sql.Types.INTEGER:
                return "INTEGER";
            case java.sql.Types.BIGINT:
                return "BIGINT";
            case java.sql.Types.TINYINT:
                return "TINYINT";
            case java.sql.Types.SMALLINT:
                return "SMALLINT";
            case java.sql.Types.VARCHAR:
                return "VARCHAR";
            case java.sql.Types.CHAR:
                return "CHAR";
            case java.sql.Types.LONGVARBINARY:
                return "LONGVARBINARY";
            case java.sql.Types.LONGVARCHAR:
                return "LONGVARCHAR";
            case java.sql.Types.DATE:
                return "DATE";
            case java.sql.Types.TIMESTAMP:
                return "TIMESTAMP";
            case Types.BIT:
                return "BIT";
            default:
                System.out.println("找不到数据类型："+databaseType);
                return "VARCHAR";
        }
    }

    /**
     * 从属性文件获取配置
     */
    public synchronized static String getPropertyFromFile(String filename, String key) {
        String paodingAnalysisPath = System.getProperty("user.dir") + "\\"+filename;

        InputStream in1;
        ResourceBundle rb=null;
        try {
            in1 = new BufferedInputStream(new FileInputStream(paodingAnalysisPath));
            rb = new PropertyResourceBundle(in1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert rb != null;
        return rb.getString(key).trim();
    }
}
