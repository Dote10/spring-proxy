package com.core.springproxy.config;

import com.core.springproxy.app.v1.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV1Config {


    @Bean
    public OrderControllerV1 ordersControllerV1() {
        return new OrderControllerV1Impl(orderServiceV1());
    }


    @Bean
    public OrderServiceV1 orderServiceV1() {
        return new OrderServiceV1Impl(orderRepositoryV1());
    }


    @Bean
    public OrderRepositoryV1 orderRepositoryV1() {
        return new OrderRepositortyV1Impl();
    }


}