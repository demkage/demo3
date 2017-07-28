package com.example.demo3.micro.parser.service.impl;

import com.example.demo3.micro.parser.data.ParseObject;
import com.example.demo3.micro.parser.service.ParserService;
import com.example.demo3.micro.parser.util.parser.JsonBasedContextBuilder;
import com.example.demo3.micro.parser.util.parser.TemplateExpressionParser;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

/**
 * Created by abosii on 7/13/17.
 */
@Service
public class ParserServiceImpl implements ParserService {

    @Override
    public Object parseString(String value, String format) {
        ExpressionParser expressionParser = new SpelExpressionParser();

        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
        standardEvaluationContext.setVariable("value", value);

        Expression expression = expressionParser.parseExpression(format);

        return expression.getValue(standardEvaluationContext);
    }

    @Override
    public Object parse(ParseObject parseObject) {
        return parseString(parseObject.getMessage(), parseObject.getFormat());
    }

    @Override
    public Object parseJson(ParseObject parseObject) {
        TemplateExpressionParser expressionParser = new TemplateExpressionParser();

        EvaluationContext context = new JsonBasedContextBuilder().data(parseObject.getMessage()).build();

        context.setVariable("Test", "test1");

        return expressionParser.parseObject(context,
                parseObject.getFormat());

    }
}
