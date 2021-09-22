package edu.pkch.spring.beanfind;

import edu.pkch.spring.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ConfigurationTest {

    @Test
    void configuration() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = ac.getBean("appConfig", AppConfig.class);
        System.out.println(appConfig);
    }
}
