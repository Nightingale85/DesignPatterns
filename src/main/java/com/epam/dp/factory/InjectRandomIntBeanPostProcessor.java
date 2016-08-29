package com.epam.dp.factory;

import com.epam.dp.factory.annotations.InjectRandomInt;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Random;

/**
 * @author Sergiy_Solovyov
 */
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {

    private Collection beans;
    private Random random = new Random();

    @Override
    public void process(Collection beans) {
        for (Object o : beans) {
            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(InjectRandomInt.class))
                    injectRandomInt(o, field);
            }
        }
    }

    private void injectRandomInt(Object o, Field field){
        try {
            field.setAccessible(true);
            field.setInt(o , random.nextInt());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
