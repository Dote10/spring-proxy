package com.core.springproxy.app.v1;

public class OrderRepositortyV1Impl implements OrderRepositoryV1{
    @Override
    public void save(String itemId) {
        //저장로직
        if(itemId.equals("ex")){
            throw new IllegalStateException("예외 발생!");
        }
        sleep(1000);

    }

    private static void sleep(int mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
