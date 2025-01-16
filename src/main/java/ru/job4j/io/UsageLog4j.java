package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Ayrat Tazetdinov";
        int age = 35;
        byte teeth = 32;
        short height = 177;
        long lego = 100500L;
        double weight = 71.3;
        float tomato = 3.14F;
        boolean spaghettiMonster = true;
        char enter = 'Y';
        LOG.debug("User info name : {}, age : {}, teeth : {}, height : {},"
                        + " lego : {}, weight : {}, tomato : {}, spaghettiMonster : {}, enter : {}",
                name, age, teeth, height, lego, weight, tomato, spaghettiMonster, enter);
    }
}