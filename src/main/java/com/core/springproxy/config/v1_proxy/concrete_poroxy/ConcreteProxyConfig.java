package com.core.springproxy.config.v1_proxy.concrete_poroxy;

import com.core.springproxy.app.v2.OrderControllerV2;
import com.core.springproxy.app.v2.OrderRepositoryV2;
import com.core.springproxy.app.v2.OrderServiceV2;
import com.core.springproxy.trace.logTrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)
)
public class ConcreteProxyConfig {

    @Bean
    public OrderControllerConcreteProxy orderControllerConcrete(LogTrace logTrace){
        OrderControllerV2 orderControllerV2 = new OrderControllerV2(orderServiceConcrete(logTrace));
        return new OrderControllerConcreteProxy(orderControllerV2,logTrace);
    }

    @Bean
    public OrderServiceConcreteProxy orderServiceConcrete(LogTrace logTrace){
        OrderServiceV2 orderService = new OrderServiceV2(orderRepositoryConcrete(logTrace));
        return new OrderServiceConcreteProxy(orderService,logTrace);
    }

    @Bean
    public  OrderRepositoryConcreteProxy orderRepositoryConcrete(LogTrace logTrace){
        OrderRepositoryV2 orderRepository = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(orderRepository,logTrace);
    }

}
