package com.mycompany.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by shuttle on 07.07.16.
 */
public class Bootstrap {

    Operations operAdd;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);
        bootstrap.execute();
    }

    public Integer execute() {

        Scanner scanner = new Scanner(System.in);
        Integer result = 0, var0 = 0, var1 = 0;
        String Line1;
        Line1 = scanner.nextLine();

        List<String> list = new ArrayList<String>(Arrays.asList(Line1.split(" ")));
        var0 = Integer.valueOf(list.get(0));
        var1 = Integer.valueOf(list.get(2));

        switch (list.get(1)) {
            case "+": result = operAdd.Add(var0, var1);
                break;
            case "-": result = operAdd.Sub(var0, var1);
                break;
            case "*": result = operAdd.Mult(var0, var1);
                break;
        }
        System.out.println(result);
        return result;
    }

    public void setOperAdd(Operations operAdd) {
        this.operAdd = operAdd;
    }
}
