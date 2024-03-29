package com.core.springproxy.pureproxy.proxy;

import com.core.springproxy.pureproxy.proxy.code.CacheProxy;
import com.core.springproxy.pureproxy.proxy.code.ProxyPatternClient;
import com.core.springproxy.pureproxy.proxy.code.RealSubject;
import com.core.springproxy.pureproxy.proxy.code.Subject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest(){
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest(){
        Subject realSubject =new RealSubject();
        Subject cacheProxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);
        client.execute();
        //메모리에서 바로 리턴
        client.execute();
        client.execute();
    }
}
