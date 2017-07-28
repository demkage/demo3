package com.example.demo3.micro.parser.controller;

import com.example.demo3.micro.parser.data.ParseObject;
import com.example.demo3.micro.parser.service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by abosii on 7/13/17.
 */
@RestController
public class FormatController {

    @Autowired
    private ParserService parserService;

    @RequestMapping(value = "/format", method = RequestMethod.POST)
    public ResponseEntity formatString(@RequestBody ParseObject object) {
        return ResponseEntity.ok(parserService.parseJson(object));
    }
}
