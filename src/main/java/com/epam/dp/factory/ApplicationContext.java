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
            initializeClass(clazz);
        }
    }
    private void initializeClass(Class clazz){

        try {
            Constructor constructor = clazz.getConstructor(java.util.Collection.class);
            Collection collection =  beanFactory.getBeans();
            constructor.newInstance(collection);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println(e.getTargetException());
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
