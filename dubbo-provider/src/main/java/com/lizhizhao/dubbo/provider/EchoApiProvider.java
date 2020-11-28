package com.lizhizhao.dubbo.provider;


import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.lizhizhao.dubbo.provider.service.EchoService;
import com.lizhizhao.dubbo.provider.service.impl.EchoServiceImpl;

import java.io.IOException;

/**
 * 基于api方式暴露服务
 */
public class EchoApiProvider {

    public static void main(String[] args) throws IOException {
        ServiceConfig<EchoService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("java-echo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181")); // ①创建注册中心，并指定ZooKeeper 协议、IP 和端口
        service.setInterface(EchoService.class); //② 指定服务暴露的接口
        service.setRef(new EchoServiceImpl()); //③ 指定真实服务对象
        service.export(); //④ 暴露服务
        System.out.println("java-echo-provider is running.");
        System.in.read();
    }
}