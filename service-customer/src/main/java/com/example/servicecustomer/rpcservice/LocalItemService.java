package com.example.servicecustomer.rpcservice;


import org.springframework.stereotype.Component;

@Component
public class LocalItemService implements RpcItemService {
    @Override
    public String demo() {
        return "远程服务熔断";
    }
}
