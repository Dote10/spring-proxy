package com.core.springproxy.config.v1_proxy.concrete_poroxy;

import com.core.springproxy.app.v2.OrderControllerV2;
import com.core.springproxy.app.v2.OrderServiceV2;
import com.core.springproxy.trace.TraceStatus;
import com.core.springproxy.trace.logTrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;


public class OrderControllerConcreteProxy extends OrderControllerV2{


    private  OrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(OrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @GetMapping("/v2/order")
    @Override
    public String createOrder(String itemId){
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderCreateConcreteProxy.createOrder()");
            target.createOrder(itemId);
            logTrace.end(status);
            return "ok";
        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }

    @GetMapping("/v2/no-log")
    @Override
    public String noLog() {
        return target.noLog();
    }
}
