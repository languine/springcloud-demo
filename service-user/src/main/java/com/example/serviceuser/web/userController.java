package com.example.serviceuser.web;

import com.example.serviceuser.pojo.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class userController {
    @Value("${server.port}")
    String port;
    @RequestMapping("/user")
    public String home (@RequestParam(value = "name",defaultValue = "forezp")String name){
        return "user " + name + " ,i am from port:" + port;
    }

    @GetMapping("/hello")
    public String demo(){
        return "hello," + port;
    }

    @GetMapping("/item")
    public List<Item> getAllItems(){

        List<Item> list = new ArrayList<>();
        Item item = new Item();
        item.setId(1L);
        item.setName("联想电脑");
        item.setPrice(Float.parseFloat(port));
        Item item2 = new Item();
        item2.setId(1L);
        item2.setName("联想电脑");
        item2.setPrice(Float.parseFloat(port));
        list.add(item);
        list.add(item2);

        return list ;
    }

}
