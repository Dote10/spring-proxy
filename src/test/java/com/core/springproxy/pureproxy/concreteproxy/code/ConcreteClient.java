package com.core.springproxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;


public class ConcreteClient {
    private ConcreteLogic concreteLogic; //ConcreteLoic, TimeProxy 모두 주입 가능

    public ConcreteClient(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    public void execute(){
        concreteLogic.operation();
    }
}
