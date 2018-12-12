package com.demon.mybatis.generator.model;

import com.demon.mybatis.generator.StringUtils;

/**
 * 列信息实体
 */
public class Column {

    /**
     * 数据库中列名称
     */
    private String columnName;
    /**
     * 生成实体字段名称
     */
    private String fieldName;
    /**
     * 生成实体字段类型
     */
    private String fieldType;
    /**
     * get方法
     */
    private String fieldGetMethod;
    /**
     * set方法
     */
    private String fieldSetMehtod;
    /**
     * 列数据类型
     */
    private int columnType;
    /**
     * 列注释
     */
    private String columnComment;
    /**
     * 是否主键
     */
    private boolean isPrimary = false;
    /**
     * 是否自动递增
     */
    private boolean isAutoIncrement = false;
    /**
     * 是否允许空
     */
    private boolean isNullAble=false;
    /**
     * 是否是外键
     */
    private boolean isForeignKey=false;

    public boolean isForeignKey() {
        return isForeignKey;
    }

    public void setForeignKey(boolean isForeignKey) {
        this.isForeignKey = isForeignKey;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
        this.fieldName = StringUtils.getDomainColumnName(columnName);
    }

    public String getColumnType() {
//        return columnType;
	    return StringUtils.getColumnType(this.columnType);
    }

    public void setColumnType(int columnType) {
        this.columnType = columnType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public boolean isAutoIncrement() {
        return isAutoIncrement;
    }

    public void setAutoIncrement(boolean isAutoIncrement) {
        this.isAutoIncrement = isAutoIncrement;
    }

    public boolean isNullAble() {
        return isNullAble;
    }

    public void setNullAble(boolean isNullAble) {
        this.isNullAble = isNullAble;
    }

    public String getFieldName() {
        // 驼峰命名法
        this.fieldName = StringUtils.getClassLower(StringUtils.getDomainColumnName(this.columnName));
//        this.fieldName = this.columnName;
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }


    public String getFieldType() {
        this.fieldType = StringUtils.getFieldType(this.columnType);
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldGetMethod() {
        if(null != this.fieldName){
            this.fieldGetMethod = StringUtils.getGetMethod(this.fieldName);
        } else {
            if(null != this.columnName){
                this.fieldGetMethod = StringUtils.getGetMethod(this.columnName);
            }
        }
        return fieldGetMethod;
    }

    public void setFieldGetMethod(String fieldGetMethod) {
        this.fieldGetMethod = fieldGetMethod;
    }

    public String getFieldSetMehtod() {
        if(null != this.fieldName) {
            this.fieldSetMehtod = StringUtils.getSetMethod(this.fieldName);
        } else {
            if(null != this.columnName){
                this.fieldSetMehtod = StringUtils.getSetMethod(this.columnName);
            }
        }
        return fieldSetMehtod;
    }

    public void setFieldSetMehtod(String fieldSetMehtod) {
        this.fieldSetMehtod = fieldSetMehtod;
    }

    /**
     * 判断是否为查询参数,需要符合以下条件:
     * 0. 跳过注释包含 #忽略# 的
     * 1. Integer,Long 类型的都为查询参数
     * 2. 注释包含#查询#
     * 3. 主键
     * 4. 字段名等于 phone,mobile,email,qq
     * 5. 字段名以 status,type 结尾
     * @return
     */
    public boolean isQueryDto() {
        String fieldType = StringUtils.getFieldType(this.columnType);
        if (org.apache.commons.lang.StringUtils.isNotBlank(this.columnComment)
                && this.columnComment.contains("#忽略#")) {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isNotBlank(this.columnComment)
                && this.columnComment.contains("#查询#")) {
            return true;
        }
        if (fieldType.equals("Integer") || fieldType.equals("Long")) {
            return true;
        }
        if (this.isPrimary) {
            return true;
        }
        if ("phone,mobile,email,qq".contains(this.columnName)) {
            return true;
        }
        if (this.columnName.endsWith("status") || this.columnName.endsWith("type")) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Column{" +
                "columnName='" + columnName + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", fieldGetMethod='" + fieldGetMethod + '\'' +
                ", fieldSetMehtod='" + fieldSetMehtod + '\'' +
                ", columnType=" + columnType +
                ", columnComment='" + columnComment + '\'' +
                ", isPrimary=" + isPrimary +
                ", isAutoIncrement=" + isAutoIncrement +
                ", isNullAble=" + isNullAble +
                ", isForeignKey=" + isForeignKey +
                '}';
    }
}
