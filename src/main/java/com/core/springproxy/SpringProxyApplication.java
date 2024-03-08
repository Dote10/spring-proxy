package com.core.springproxy;

import com.core.springproxy.config.AppV1Config;
import com.core.springproxy.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import({AppV1Config.class,AppV2Config.class})
@SpringBootApplication(scanBasePackages = "com.core.springproxy.app")
public class SpringProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProxyApplication.class, args);
    }

}
