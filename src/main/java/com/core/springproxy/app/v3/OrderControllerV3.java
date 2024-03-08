package com.core.springproxy.app.v3;

import com.core.springproxy.app.v2.OrderServiceV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ResponseBody
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;

    public OrderControllerV3(OrderServiceV3 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/v3/order")
    String createOrder(@RequestParam("itemId") String itemId){
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/v3/no-log")
    String noLog(){
        return "ok";
    }

}
