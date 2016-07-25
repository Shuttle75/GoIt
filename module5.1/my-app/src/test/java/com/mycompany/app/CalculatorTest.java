package com.mycompany.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayInputStream;

public class CalculatorTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);
        ByteArrayInputStream in;

        System.out.println("5 + 5");
        in = new ByteArrayInputStream("5 + 5".getBytes());
        System.setIn(in);
        bootstrap.execute();

        System.out.println("5 - 5");
        in = new ByteArrayInputStream("5 - 5".getBytes());
        System.setIn(in);
        bootstrap.execute();

        System.out.println("5 * 5");
        in = new ByteArrayInputStream("5 * 5".getBytes());
        System.setIn(in);
        bootstrap.execute();
    }
}
