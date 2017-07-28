package com.example.demo3.micro.parser.service;

import com.example.demo3.micro.parser.data.ParseObject;

/**
 * Created by abosii on 7/13/17.
 */
public interface ParserService {
    Object parseString(String value, String format);

    Object parse(ParseObject parseObject);

    Object parseJson(ParseObject parseObject);
}
