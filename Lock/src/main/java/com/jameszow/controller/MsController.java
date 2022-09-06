package com.jameszow.controller;

import com.jameszow.service.RedissonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "ms")
public class MsController {

    @Autowired
    private RedissonService redissonService;

    @RequestMapping(value = "redisson",method = RequestMethod.GET)
    public String redisson(String product_id){
        String str = redissonService.demo(product_id);
        return str;
    }
}
