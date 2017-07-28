package com.example.demo3.micro.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by abosii on 7/27/17.
 */
@RestController
@RequestMapping("/hi")
public class HiController {
    @Value("${eureka.instance.instanceId}")
    String instanceName;

    @RequestMapping()
    public String sayHi() {
        return "Hi from #" + instanceName;
    }
}
