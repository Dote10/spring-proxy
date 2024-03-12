package com.core.springproxy.config.v1_proxy.concrete_poroxy;


import com.core.springproxy.app.v2.OrderRepositoryV2;
import com.core.springproxy.trace.TraceStatus;
import com.core.springproxy.trace.logTrace.LogTrace;

public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;

    public OrderRepositoryConcreteProxy(OrderRepositoryV2 target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }

    public void save(String itemId){
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderRepositoryConcreteProxy.save()");

            if (itemId == "ex") {

                throw new IllegalStateException(" 오류가 발생 했습니다!");
            }
            sleep(1000);
            logTrace.end(status);
        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }

    private static void sleep(int mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
