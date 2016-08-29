package com.epam.dp.factory;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Set;

/**
 * @author Sergiy_Solovyov
 */
public class ApplicationContext  {

    protected BeanFactory beanFactory;
    private Reflections reflections =
            new Reflections("com.epam.dp.factory");

    public ApplicationContext(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        init();
    }
    private void init() {
        Set<Class<? extends BeanPostProcessor>> subTypesOf =
                reflections.getSubTypesOf(BeanPostProcessor.class);
        for (Class<? extends BeanPostProcessor> clazz : subTypesOf) {
            runBeanPostProcessor(clazz);
        }
    }
    private void runBeanPostProcessor(Class clazz){

        try {
            BeanPostProcessor bpp = (BeanPostProcessor) clazz.newInstance();

            bpp.process(beanFactory.getBeans());

        } catch (InstantiationException|IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
