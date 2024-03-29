package com.core.springproxy.app.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@ResponseBody
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;

    public OrderControllerV2(OrderServiceV2 orderService) {
        this.orderService = orderService;
    }


    public String createOrder(@RequestParam("itemId") String itemId){
        orderService.orderItem(itemId);
        return "ok";
    }


    public String noLog(){
        return "ok";
    }

}
