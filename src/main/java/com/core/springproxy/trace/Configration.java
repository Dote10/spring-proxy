package com.core.springproxy.trace;

import com.core.springproxy.trace.logTrace.LogTrace;
import com.core.springproxy.trace.logTrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configration {
    @Bean
    public LogTrace logTrace(){
        // return new FieldLogTrace();
        return new ThreadLocalLogTrace();
    }


}
