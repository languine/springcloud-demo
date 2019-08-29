package com.example.servicecustomer.itemweb.web;

import com.example.servicecustomer.itemweb.web.pojo.Item;
import com.example.servicecustomer.rpcservice.RpcItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(){
        return restTemplate.getForObject("http://service-user/hello",String.class);
    }

    @GetMapping("/getItemById/{id}")
    public Item getItemById(@PathVariable Long id){

        //restTemplate远程服务调用
        String url = "http://service-user/item/"+id;
        Item item = restTemplate.getForObject(url, Item.class);

        return item;
    }


    @Autowired
    RpcItemService rpcItemService;

    @GetMapping("/demo2")
    public String demo2(){
        return rpcItemService.demo();
    }


}
