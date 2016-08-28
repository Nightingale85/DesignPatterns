package com.epam.dp.factory;

import com.epam.dp.factory.annotations.Component;
import com.epam.dp.factory.annotations.InjectRandomInt;

/**
 * @author Sergiy_Solovyov
 */
@Component("Lammi")
public class TestClass {
    @InjectRandomInt
    public int test;

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "test=" + test +
                '}';
    }
}
