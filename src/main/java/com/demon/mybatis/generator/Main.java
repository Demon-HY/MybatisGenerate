package com.demon.mybatis.generator;

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
                "jdbc:mysql://127.0.0.1:3306/xdd_user?useUnicode=true&amp;characterEncoding=UTF-8&amp;allowMultiQueries=true",
                "root",
                "root",
                "com.xdd.support.msgPush",
                "Demon-HY",
                "",
                "e:/code/generator_181211"
        );
    }
}
