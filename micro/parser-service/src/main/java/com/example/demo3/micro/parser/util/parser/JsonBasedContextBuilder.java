package com.example.demo3.micro.parser.util.parser;

import groovy.json.JsonSlurper;
import groovy.json.internal.LazyMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.AccessException;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created by abosii on 7/14/17.
 */
public class JsonBasedContextBuilder implements ContextBuilder {
    private static final Logger log = LoggerFactory.getLogger(JsonBasedContextBuilder.class);

    private Object jsonObject;

    @Override
    public EvaluationContext build() {
        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();


        evaluationContext.setRootObject(jsonObject);
        evaluationContext.addPropertyAccessor(new MapAccessor());

        return evaluationContext;
    }

    @Override
    public ContextBuilder data(Object data) {

        jsonObject = new JsonSlurper().parseText((String) data);

        return this;
    }

}
