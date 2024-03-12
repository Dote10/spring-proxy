package com.core.springproxy.config.v1_proxy.concrete_poroxy;

import com.core.springproxy.app.v2.OrderRepositoryV2;
import com.core.springproxy.app.v2.OrderServiceV2;
import com.core.springproxy.trace.TraceStatus;
import com.core.springproxy.trace.logTrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2{

    private final OrderServiceV2 orderService;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy( OrderServiceV2 orderService, LogTrace logTrace) {
        super(null);
        this.orderService = orderService;
        this.logTrace = logTrace;
    }
    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderServiceConcreteProxy.orderItem()");
            orderService.orderItem(itemId);
            logTrace.end(status);
        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }

}
