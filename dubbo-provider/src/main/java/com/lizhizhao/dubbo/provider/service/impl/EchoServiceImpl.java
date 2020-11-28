package com.lizhizhao.dubbo.provider.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.lizhizhao.dubbo.provider.service.EchoService;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基于注解提供服务实现类
 */
@Service
@Slf4j
public class EchoServiceImpl implements EchoService {
    public String echo(String message) {
        String now = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("[" + now + "] echo " + message + "， request from consumer: " + RpcContext.getContext().getRemoteAddress());
        log.info("[成功调用] echo " + message + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return message;
    }
}
