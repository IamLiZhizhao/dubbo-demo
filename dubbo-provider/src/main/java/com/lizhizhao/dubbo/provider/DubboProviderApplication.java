package com.lizhizhao.dubbo.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class DubboProviderApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DubboProviderApplication.class, args);
        //加载xml配置文件启动
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/provider.xml");   //①指定服务暴露配置文件
        context.start();    // ②启动Spring容器并暴露服务
        try {
            System.in.read(); // 按任意键退出
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
