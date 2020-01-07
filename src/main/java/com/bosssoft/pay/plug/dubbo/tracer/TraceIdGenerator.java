package com.bosssoft.pay.plug.dubbo.tracer;

import java.util.UUID;

/**
 * @Title TraceId生成器
 * @Description
 * @Author 陈超雷(chenchaoleicn@gmail.com)
 * @Date 2019/5/22
 */
public class TraceIdGenerator {

    public static String generateTraceId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
