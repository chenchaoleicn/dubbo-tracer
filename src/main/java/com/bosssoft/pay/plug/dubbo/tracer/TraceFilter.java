package com.bosssoft.pay.plug.dubbo.tracer;


import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title Dubbo过滤器(用于在服务之间传递TraceId)
 * @Description
 * @Author 陈超雷(chenchaoleicn@gmail.com)
 * @Date 2019/5/22
 */
@Activate(group = {com.alibaba.dubbo.common.Constants.PROVIDER, com.alibaba.dubbo.common.Constants.CONSUMER})
public class TraceFilter implements Filter {

     private static final Logger LOGGER = LoggerFactory.getLogger(TraceFilter.class);
     private static final String EMPTY_STR = "";

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext rpcContext = RpcContext.getContext();
        String traceId = EMPTY_STR;
        if (rpcContext.isConsumerSide()) {
            traceId = ThreadContextService.getTraceId();
            if (StringUtils.isBlank(traceId)) {
                traceId = TraceIdGenerator.generateTraceId();
                ThreadContextService.setTraceId(traceId);
            }
            RpcContext.getContext().setAttachment(Constants.TRACE_ID, traceId);
        }
        if (rpcContext.isProviderSide()) {
            // 服务提供方, 从Rpc上下文获取traceId
            traceId = RpcContext.getContext().getAttachment(Constants.TRACE_ID);
            ThreadContextService.setTraceId(traceId);
        }
        return invoker.invoke(invocation);
    }
}
