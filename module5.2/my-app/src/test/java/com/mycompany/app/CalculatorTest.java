package com.mycompany.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayInputStream;

public class CalculatorTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);

        Logger logger = LoggerFactory.getLogger(Bootstrap.class);

        ByteArrayInputStream in;

        logger.info("Logger: Before operation");
        System.out.println("5 + 5");
        in = new ByteArrayInputStream("5 + 5".getBytes());
        System.setIn(in);
        bootstrap.execute();
        logger.info("Logger:  After operation");

        logger.info("Logger: Before operation");
        System.out.println("10 - 5");
        in = new ByteArrayInputStream("10 - 5".getBytes());
        System.setIn(in);
        bootstrap.execute();
        logger.info("Logger:  After operation");

        logger.info("Logger: Before operation");
        System.out.println("5 * 5");
        in = new ByteArrayInputStream("5 * 5".getBytes());
        System.setIn(in);
        bootstrap.execute();
        logger.info("Logger:  After operation");
    }
}
