package com.demon.mybatis.generator;

import com.demon.mybatis.generator.mybatis.MybatisCodeGenerator;

/**
 * Created by Demon-HY on 2017/7/22 0022.
 */
public class Main {

    public static void main(String[] args) {
        // 生成 mybatis
        MybatisCodeGenerator mybatisCode = new MybatisCodeGenerator();
        mybatisCode.generator(
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://127.0.0.1:3306/demon_sys?characterEncoding=utf-8&useUnicode=true&zeroDateTimeBehavior=convertToNull",
                "root",
                "root",
                "org.demon.admin.system",
                "Demon-HY",
                "sys_menu",
                "e:/code/generator_1130"
        );
    }
}
