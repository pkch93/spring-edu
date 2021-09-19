package edu.pkch.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringEduApplication {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("context/bean-factory-beans.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        System.out.println(beanFactory.getBean("person"));
    }
}
