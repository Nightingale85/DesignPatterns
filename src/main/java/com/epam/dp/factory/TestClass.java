package com.epam.dp.factory;

import com.epam.dp.factory.annotations.Component;
import com.epam.dp.factory.annotations.InjectRandomInt;

/**
 * @author Sergiy_Solovyov
 */
@Component("Lammi")
public class TestClass {
    @InjectRandomInt
    public int randomInt;

    public int getTest() {
        return randomInt;
    }

    public void setTest(int test) {
        this.randomInt = test;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "randomInt=" + randomInt +
                '}';
    }
}
