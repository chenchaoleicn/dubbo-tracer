package com.bosssoft.pay.plug.dubbo.tracer;

import org.slf4j.MDC;

/**
 * @Title 线程上下文工具类
 * @Description
 * @Author 陈超雷(chenchaoleicn@gmail.com)
 * @Date 2019/5/22
 */
public class ThreadContextService {

    private static final String TRACE_ID = Constants.TRACE_ID;

    public static String getTraceId() {
        return MDC.get(TRACE_ID);
    }

    public static void setTraceId(String traceId) {
        MDC.put(TRACE_ID, traceId);
    }

    public static void removeTraceId() {
        MDC.remove(TRACE_ID);
    }

}
