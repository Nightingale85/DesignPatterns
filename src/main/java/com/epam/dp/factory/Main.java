package com.epam.dp.factory;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author Ivan_Zhuravel
 */
public class Main {

    public static void main(String[] args) {

        BeanFactory beanFactory = new BeanFactory();
        ApplicationContext context = new ApplicationContext(beanFactory);
        Collection beans = beanFactory.getBeans();
        for (Object o: beans) {
            System.out.println(o);
        }
    }
}
