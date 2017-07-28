package com.example.demo3.micro.parser.data;

/**
 * Created by abosii on 7/13/17.
 */
public class ParseObject {
    private String message;
    private String format;

    public ParseObject() {

    }

    public ParseObject(String message, String format) {
        this.message = message;
        this.format = format;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
