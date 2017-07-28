package com.example.demo3.micro.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by abosii on 7/24/17.
 */
@Controller
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/{path:(?!.*.js|.*.css|.*.jpg).*$}")
    public String index(Model model, HttpServletRequest request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> req = new HashMap<>();
        Map<String, Object> state = new HashMap<>();
        state.put("message", "{ Welcome from server }");
        state.put("format",  "${}");

        String root = request.getServletPath().equals("/index.html") ? "/" : request.getServletPath();

        if(request.getQueryString() != null) {
            req.put("location", String.format("%s?%s", root, request.getQueryString()));
        } else {
            req.put("location", root);
        }

        log.info(mapper.writeValueAsString(state));
        model.addAttribute("state", mapper.writeValueAsString(state));
        model.addAttribute("req", mapper.writeValueAsString(req));
        return "index";
    }
}
