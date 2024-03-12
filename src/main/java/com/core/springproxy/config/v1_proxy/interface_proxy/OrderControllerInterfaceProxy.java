package com.core.springproxy.config.v1_proxy.interface_proxy;

import com.core.springproxy.app.v1.OrderControllerV1;
import com.core.springproxy.trace.TraceStatus;
import com.core.springproxy.trace.logTrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

    private final OrderControllerV1 target;
    private  final LogTrace logTrace;

    @GetMapping("/v1/order")
    @Override
    public String createOrder(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.createOrder()");
            String result = target.createOrder(itemId);
            logTrace.end(status);
            return result;
        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
