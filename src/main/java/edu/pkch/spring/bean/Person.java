package edu.pkch.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Person implements InitializingBean, DisposableBean {
    private String name;
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * BeanFactory에서는 동작하지 않음.
     * ApplicationContext를 활용해야만 동작
     */
    @PostConstruct
    @Override
    public void afterPropertiesSet() {
        System.out.println("person bean is initial" + this);
    }

    /**
     * BeanFactory에서는 동작하지 않음.
     * ApplicationContext를 활용해야만 동작
     */
    @PreDestroy
    @Override
    public void destroy() {
        System.out.println("person bean will be destroyed" + this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
