package com.example.servicecustomer.rpcservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "service-user",fallback = LocalItemService.class )//服务名
public interface RpcItemService {

    @GetMapping("/user")
    public String demo(); //参数  和 返回值   要和你即将远程调用的服务接口的参数和返回值一致
}


