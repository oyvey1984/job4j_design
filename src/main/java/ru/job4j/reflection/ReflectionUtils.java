package ru.job4j.reflection;

import java.lang.reflect.ParameterizedType;

public class ReflectionUtils {

    public static Class getGenericParameterClass(Class actualClass, int parameterIndex) {

        return (Class) ((ParameterizedType) actualClass
                .getGenericSuperclass())
                .getActualTypeArguments()[parameterIndex];
    }
}