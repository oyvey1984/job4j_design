package ru.job4j.reflection;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public class FloatList extends ArrayList<Float> {
    static ArrayList<Float> listOfNumbers = new FloatList();

    public static void getGeneric() {
        Class actualClass = listOfNumbers.getClass();
        System.out.println(actualClass);

        ParameterizedType type = (ParameterizedType) actualClass.getGenericSuperclass();
        System.out.println(type); // java.util.ArrayList<java.lang.Float>

        Class parameter = (Class) type.getActualTypeArguments()[0];
        System.out.println(parameter); // class java.lang.Float
    }

    public static void main(String[] args) {
        getGeneric();
    }

    public Class getEntityClass() {
        return ReflectionUtils.getGenericParameterClass(this.getClass(), 0);
    }
}
