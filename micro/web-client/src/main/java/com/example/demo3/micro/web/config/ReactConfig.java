package com.example.demo3.micro.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

/**
 * Created by abosii on 7/24/17.
 */
@Configuration
public class ReactConfig {

    @Bean
    public ViewResolver reactViewResolver() {
        ScriptTemplateViewResolver viewResolver = new ScriptTemplateViewResolver();
        viewResolver.setPrefix("public/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }


    @Bean
    public ScriptTemplateConfigurer scriptTemplateConfigurer() {
        ScriptTemplateConfigurer configurer = new ScriptTemplateConfigurer();
        configurer.setEngineName("nashorn");
        configurer.setScripts("/META-INF/resources/webjars/react/15.6.1/react.js",
                "/META-INF/resources/webjars/react-dom/15.6.1/dist/react-dom-server.js",
                "polyfill.js",
                "/META-INF/resources/webjars/ejs/2.5.2/ejs-v2.5.2/ejs.min.js",
//                "static/service-worker.js",
//                "static/bundle.js",
                "static/server.bundle.js");
        configurer.setRenderFunction("render");
        configurer.setRenderObject("window");
        configurer.setSharedEngine(false);
        return configurer;
    }
}
