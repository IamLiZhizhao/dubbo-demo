package com.lizhizhao.dubbo.consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lizhizhao.dubbo.provider.service.ProviderService;

import java.io.IOException;

@SpringBootApplication
@ComponentScan("com.lizhizhao")
public class DubboConsumerApplication {

    public static void main(String[] args) throws IOException {
//        SpringApplication.run(DubboConsumerApplication.class, args);

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        String str = providerService.SayHello("hello");
        System.out.println(str);
        System.in.read();
    }

}
