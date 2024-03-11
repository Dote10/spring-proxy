package com.core.springproxy.config.v1_proxy.interface_proxy;

import com.core.springproxy.app.v1.*;
import com.core.springproxy.app.v2.OrderControllerV2;
import com.core.springproxy.trace.logTrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public OrderControllerV1 ordersController(LogTrace logTrace){
        OrderControllerV1 controllerImpl = new OrderControllerV1Impl(orderService(logTrace));
        return new OrderControllerInterfaceProxy(controllerImpl,logTrace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace){
        OrderServiceV1 serviceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl,logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace){
        OrderRepositoryV1 repositoryImpl = new OrderRepositortyV1Impl();
        return new OrderRepositoryInterfaceProxy(repositoryImpl,logTrace);
    }

}
