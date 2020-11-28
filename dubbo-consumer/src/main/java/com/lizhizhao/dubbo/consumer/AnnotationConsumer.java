package com.lizhizhao.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.lizhizhao.dubbo.consumer.consumer.EchoConsumer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 基于注解实现服务消费
 */
public class AnnotationConsumer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        // ①基于注解配置初始化Spring上下文
        context.start();
        EchoConsumer echoService = context.getBean(EchoConsumer.class);
        String hello = echoService.echo("Hello world!"); //②发起服务调用
        System.out.println("result: " + hello);
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.lizhizhao.dubbo.consumer.consumer") //③ 指定要扫描的消费注解，会触发注入
    @ComponentScan(value = {"com.lizhizhao.dubbo.consumer.consumer"})
    static class ConsumerConfiguration {
        @Bean
        public ApplicationConfig applicationConfig() {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("echo-annotation-consumer");
            return applicationConfig;
        }

        @Bean
        public ConsumerConfig consumerConfig() {
            return new ConsumerConfig();
        }

        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setProtocol("zookeeper"); // 使用zookeeper作为注册中心、同时给出注册中心的 ip和端口
            registryConfig.setAddress("localhost");
            registryConfig.setPort(2181);
            return registryConfig;
        }
    }
}