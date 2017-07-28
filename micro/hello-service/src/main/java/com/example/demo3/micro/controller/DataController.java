package com.example.demo3.micro.controller;

import com.example.demo3.micro.service.DataGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by abosii on 7/12/17.
 */
@RestController
@RequestMapping(path = "/data")
public class DataController {

    @Autowired
    private DataGeneratorService service;

    @RequestMapping(value = "/randomly", method = RequestMethod.GET)
    public ResponseEntity getListRandomly() {
        return ResponseEntity.ok(service.getDataList());
    }


    @RequestMapping(value = "/randomly", method = RequestMethod.POST)
    public ResponseEntity postData(@RequestParam("message") String message) {
        return ResponseEntity.ok(service.addData(message));
    }


    @RequestMapping(value = "/randomly/{message}", method = RequestMethod.DELETE)
    public ResponseEntity deleteData(@PathVariable("message") String message) {
        return ResponseEntity.ok(service.deleteData(message));
    }

    @RequestMapping(value = "/randomly/{message}", method = RequestMethod.PUT)
    public ResponseEntity putData(@PathVariable("message") String message, @RequestBody String update) {
        return ResponseEntity.ok(service.updateData(message + update));
    }

}
