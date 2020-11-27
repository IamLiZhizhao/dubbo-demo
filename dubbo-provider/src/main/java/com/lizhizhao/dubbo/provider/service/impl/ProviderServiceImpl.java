package com.lizhizhao.dubbo.provider.service.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.lizhizhao.dubbo.provider.service.ProviderService;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * xml方式服务提供者实现类
 */
@Slf4j
public class ProviderServiceImpl implements ProviderService {

    public String SayHello(String word) {
        String now = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("[" + now + "] Hello " + word +
                ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        log.info("[成功调用] Hello " + word + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return word;
    }
}