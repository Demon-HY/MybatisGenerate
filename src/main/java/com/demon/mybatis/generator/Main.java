package com.demon.mybatis.generator;

/**
 * Created by Demon-Coffee on 2017/7/22 0022.
 */
public class Main {

    public static void main(String[] args) {
        CodeGenerator code = new CodeGenerator();
        code.generator(
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://127.0.0.1:3306/control_situation?characterEncoding=utf-8&useUnicode=true&zeroDateTimeBehavior=convertToNull",
                "root",
                "123456",
                "com.control.situation",
                "Demon-Coffee",
                "",
                "f:/code/generator"
                );
    }
}
