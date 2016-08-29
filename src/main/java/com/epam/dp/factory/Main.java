package com.epam.dp.factory;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author Ivan_Zhuravel
 */
public class Main {

    public static void main(String[] args) {

        BeanFactory factory = new BeanFactory();
        //getBean without cast
        SomeClass someClass =
                factory.getBean("SomeClass");
        TestClass testClass = factory.getBean("Lammi");
        System.out.println(someClass.getTest());
        System.out.println(testClass.toString());
        System.out.println("-----------------------------------------------");
        BeanFactory beanFactory = new BeanFactory();
        ApplicationContext context = new ApplicationContext(beanFactory);
        Collection beans = beanFactory.getBeans();
        for (Object o : beans) {
            System.out.println(o);
        }
    }
}

