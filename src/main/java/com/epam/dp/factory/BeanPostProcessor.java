package com.epam.dp.factory;

import java.util.Collection;

/**
 * @author Sergiy_Solovyov
 */
public interface BeanPostProcessor {
   void process(Collection beans);
}
