package com.wzr.foodculture.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    /*单例SqlSessionFactory*/

    private static SqlSessionFactory sqlSessionFactory;

    static {
        //创建SqlSessionFactroryBuilder对象
        SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
        try{
            //查找配置文件 创建输入流
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //加载配置文件，创建SqlSessionFactory对象
            sqlSessionFactory = ssfb.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取单例SqlSessionFactory
     *
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        return  sqlSessionFactory;
    }
}
