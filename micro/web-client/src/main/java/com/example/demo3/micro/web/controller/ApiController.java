package com.example.demo3.micro.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by abosii on 7/26/17.
 */
@RestController
@RequestMapping(path = "current")
public class ApiController {

    @Value("micro.instance.name")
    String instanceName;

    @RequestMapping()
    public String message() {
        return "Hello World from instance #" + instanceName;
    }
}
