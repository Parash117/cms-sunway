package com.sunway.cms.config;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CustomMessageSource {

    private final MessageSource messageSource;

    public CustomMessageSource() {
        ReloadableResourceBundleMessageSource messageSource1 = new ReloadableResourceBundleMessageSource();
        messageSource1.setBasename("classpath:messages");
        messageSource1.setDefaultEncoding("UTF-8");
        messageSource1.setCacheSeconds(5);
        this.messageSource = messageSource1;
    }
/*
    @PostConstruct
    public MessageSource configureMessageSource(){
        return this.messageSource;
    }*/

    public String get(String code){
        return messageSource.getMessage(code, null, Locale.ENGLISH);
    }

    public String get(String code, String... strings){
        return messageSource.getMessage(code, strings, Locale.ENGLISH);
    }
}
