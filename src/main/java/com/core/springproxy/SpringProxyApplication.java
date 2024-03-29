package com.core.springproxy;

import com.core.springproxy.app.v2.OrderControllerV2;
import com.core.springproxy.config.AppV1Config;
import com.core.springproxy.config.AppV2Config;
import com.core.springproxy.config.v1_proxy.concrete_poroxy.ConcreteProxyConfig;
import com.core.springproxy.config.v1_proxy.interface_proxy.InterfaceProxyConfig;
import com.core.springproxy.trace.logTrace.LogTrace;
import com.core.springproxy.trace.logTrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;


//@Import({AppV1Config.class,AppV2Config.class})
//@Import({AppV2Config.class,InterfaceProxyConfig.class})
@Import( ConcreteProxyConfig.class)
@SpringBootApplication(scanBasePackages = "com.core.springproxy.app")
public class SpringProxyApplication {

    public static void main(String[] args) {

       ApplicationContext ac = SpringApplication.run(SpringProxyApplication.class, args);

    }

    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }

}
