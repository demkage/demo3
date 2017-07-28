package com.example.demo3.micro.parser.util.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.CompositeStringExpression;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by abosii on 7/14/17.
 */
public class TemplateExpressionParser {
    private static final TemplateParserContext DEFAULT_TEMPLATE_CONTEXT =
            new TemplateParserContext("#{", "}");

    private static final Logger log = LoggerFactory.getLogger(TemplateExpressionParser.class);

    private TemplateParserContext template = DEFAULT_TEMPLATE_CONTEXT;
    private ExpressionParser expressionParser = new SpelExpressionParser();

    public Object parseObject(EvaluationContext context, String expr) {
        Expression expression = expressionParser.parseExpression(expr, template);

        log.info("Parsed expression has value '{}'", expression.getExpressionString());

        return expression.getValue(context);
    }


//    private EvaluationContext getEvaluationContext(Object data) {
//        List<Method> getters = asList(data.getClass().getMethods())
//                .stream()
//                .filter(method -> method.isAccessible() && method.getName().startsWith("get"))
//                .collect(Collectors.toList());
//
//        final EvaluationContext evaluationContext = new StandardEvaluationContext();
//
//        getters.forEach(method -> {
//                    try {
//                        evaluationContext.setVariable(
//                                method.getName().replace("get", "").toLowerCase(),
//                                method.invoke(data)
//                        );
//                    } catch (IllegalAccessException | InvocationTargetException e) {
//                        log.warn("Trying to access inaccessible method with exception '{}' ", e.getMessage());
//                    }
//                }
//        );
//
//        return evaluationContext;
//    }

}
