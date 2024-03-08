package com.core.springproxy.config;

import com.core.springproxy.app.v1.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV1Config {

    @Bean
    public OrdersControllerV1 ordersController(){
        return new OrderControllerV1Impl(orderService());
    }

    @Bean
    public OrderServiceV1 orderService(){
        return new OrderServiceV1Impl(orderRepository());
    }

    @Bean
    public OrderRepositoryV1 orderRepository(){
        return new OrderRepositortyV1Impl();
    }
}
