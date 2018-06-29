package com.drools.springdroolsruleengine.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class DroolsConfiguration {

    @Value("${drool.company-rules.drl}")
    private String companyRules;
}
