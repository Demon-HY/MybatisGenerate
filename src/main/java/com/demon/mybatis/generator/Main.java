package com.demon.mybatis.generator;

import com.demon.mybatis.generator.mybatis.MybatisCodeGenerator;

/**
 * Created by Demon-Coffee on 2017/7/22 0022.
 */
public class Main {

    public static void main(String[] args) {

        // 用户
//        String classPackage = "com.xdd.user";
//        String tableNames = "xdd_user,xdd_real_name_auth,xdd_user_third_bind,xdd_option_log";

        // 配置
//        String classPackage = "com.xdd.support.config";
//        String tableNames = "xdd_global_config";

        // 短信
//        String classPackage = "com.xdd.support.sms";
//        String tableNames = "xdd_sms_log";

        // 消息推送
        String classPackage = "com.xdd.support.msgPush";
        String tableNames = "xdd_message_push,xdd_user_message";


        // 生成 mybatis
        MybatisCodeGenerator mybatisCode = new MybatisCodeGenerator();
        mybatisCode.generator(
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://127.0.0.1:3306/xdd_user?useUnicode=true&amp;characterEncoding=UTF-8&amp;allowMultiQueries=true",
                "root",
                "root",
                classPackage,
                "Demon-HY",
                tableNames,
                "e:/code/generator_181211_3"
        );
    }

}
