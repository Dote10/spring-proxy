package com.core.springproxy.app.v1;



import org.springframework.web.bind.annotation.*;

//@RequestMapping
@RestController//스프링은 @Contorller 또는 @RequestMpping이 있어야 스프링 컨트롤러로 인식
@ResponseBody
public interface OrderControllerV1 {

    @GetMapping("/v1/order")
    String createOrder(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}
