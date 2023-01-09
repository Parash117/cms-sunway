package com.sunway.cms.abstracts;

import com.sunway.cms.config.CustomMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public abstract class BaseController {

    @Autowired
    protected CustomMessageSource messageSource;

    protected String moduleName;

}