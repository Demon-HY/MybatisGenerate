package com.demon.mybatis.generator;

import com.demon.mybatis.generator.jdbc.JdbcCodeGenerator;
import com.demon.mybatis.generator.mybatis.MybatisCodeGenerator;

/**
 * Created by Demon-Coffee on 2017/7/22 0022.
 */
public class Main {

    public static void main(String[] args) {
        // 生成 mybatis
        MybatisCodeGenerator mybatisCode = new MybatisCodeGenerator();
        mybatisCode.generator(
                "com.mysql.jdbc.Driver",
                "",
                "",
                "",
                "p",
                "",
                "",
                ""
                );

//        // 生成 jdbc
//        // 设置模本路径
//        TemplateOption.templatePath = "template_jdbc";
//        JdbcCodeGenerator jdbcCode = new JdbcCodeGenerator();
//        jdbcCode.generator(
//                "com.mysql.jdbc.Driver",
//                "jdbc:mysql://127.0.0.1:3306/control_situation?characterEncoding=utf-8&useUnicode=true&zeroDateTimeBehavior=convertToNull",
//                "root",
//                "123456",
//                "com.control.situation",
//                "Demon-Coffee",
//                "",
//                "f:/code/generator"
//                );

    }
}
