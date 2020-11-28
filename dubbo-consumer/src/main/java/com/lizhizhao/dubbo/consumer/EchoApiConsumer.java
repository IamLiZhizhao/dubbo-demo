package com.lizhizhao.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.lizhizhao.dubbo.provider.service.EchoService;

/**
 * 通过Api方式消费服务
 */
public class EchoApiConsumer {
    public static void main(String[] args) {
        // ①设置消费方应用名称
        ReferenceConfig<EchoService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("java-echo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181")); // ②设置注册中心地址和协议
        reference.setInterface(EchoService.class);  //③指定要消费的服务接口
        EchoService greetingsService = reference.get(); //④ 创建远程连接并做动态代理转换
        String message = greetingsService.echo("Hello world!");
        System.out.println(message);
    }
}


