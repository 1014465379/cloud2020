package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderZKcontroller {
    public  static final String INVOKE_URL="http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public  String paymentinfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }

}
