package com.core.springproxy.pureproxy.concreteproxy;

import com.core.springproxy.pureproxy.concreteproxy.code.ConcreteClient;
import com.core.springproxy.pureproxy.concreteproxy.code.ConcreteLogic;
import com.core.springproxy.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

    @Test
    void addProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy proxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(proxy);
        client.execute();
    }
}
