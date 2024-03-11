package com.core.springproxy.config.v1_proxy.interface_proxy;

import com.core.springproxy.app.v1.OrderRepositoryV1;
import com.core.springproxy.trace.TraceStatus;
import com.core.springproxy.trace.logTrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    //프록시 이므로 실제 객체를 참조한다.
    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
           status = logTrace.begin("OrderRepository.save()");
           //proxy에서는 실제 호출할 대상을 target이라고 한다.
           //중간에 여러 프록시가 추가되면 target이 다른 proxy가 될 수도 있다.
           //target 호출
            target.save(itemId);
            logTrace.end(status);
        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }
}
