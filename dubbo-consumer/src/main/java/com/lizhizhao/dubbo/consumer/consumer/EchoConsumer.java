package com.lizhizhao.dubbo.consumer.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lizhizhao.dubbo.provider.service.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoConsumer {
    @Reference
    private EchoService echoService;

    public String echo(String name) {
        return echoService.echo(name);
    }
}