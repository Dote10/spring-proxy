package com.core.springproxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject{
    private Subject target;     //proxy입장에 호출해야 되는 대상을 target이라고 한다.
    private String cacheValue;  //캐시해둘 필드

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");
         if(cacheValue == null) {
             cacheValue = target.operation();
         }
         return cacheValue;

    }
}
