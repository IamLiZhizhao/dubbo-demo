package com.lizhizhao.dubbo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lizhizhao.dubbo.provider.service.ProviderService;

@SpringBootApplication
public class DubboConsumerApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DubboConsumerApplication.class, args);

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        String str = providerService.SayHello("hello");
        System.out.println(str);
        System.in.read();
    }

}
