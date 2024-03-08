package com.core.springproxy.config;

import com.core.springproxy.app.v1.*;
import com.core.springproxy.app.v2.OrderControllerV2;
import com.core.springproxy.app.v2.OrderRepositoryV2;
import com.core.springproxy.app.v2.OrderServiceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV2Config {

//    @Bean
//    public OrderControllerV2 ordersControllerV2(){
//        return new OrderControllerV2(orderServiceV2());
//    }

    @Bean
    public OrderServiceV2 orderServiceV2(){
        return new OrderServiceV2(orderRepositoryV2());
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryV2(){
        return new OrderRepositoryV2();
    }
}
