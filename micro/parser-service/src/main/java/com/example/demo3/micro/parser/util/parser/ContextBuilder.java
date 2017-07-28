package com.example.demo3.micro.parser.util.parser;

import org.springframework.expression.EvaluationContext;

/**
 * Created by abosii on 7/14/17.
 */
public interface ContextBuilder {
    EvaluationContext build();

    ContextBuilder data(Object data);
}
