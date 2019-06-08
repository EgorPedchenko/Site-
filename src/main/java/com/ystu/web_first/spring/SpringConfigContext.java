package com.ystu.web_first.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerde on 08.04.2017.
 */
@Configuration
public class SpringConfigContext {

    @Bean
    List mockList() { return new ArrayList(); }

}
