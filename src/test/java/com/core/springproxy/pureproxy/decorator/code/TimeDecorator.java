package com.core.springproxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component{


    Component messageDecorator;


    public TimeDecorator(Component messageDecorator) {
        this.messageDecorator = messageDecorator;

    }

    @Override
    public String operation() {
        log.info("TimeDecorator 실행");
        long startTime =  System.currentTimeMillis();

        String result = messageDecorator.operation();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("소요 시간 = {}ms",resultTime);
        return result;

    }
}
