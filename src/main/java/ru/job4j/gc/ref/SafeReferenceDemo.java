package ru.job4j.gc.ref;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class SafeReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        safeSoftReferenceExample();
        safeWeakReferenceExample();
    }

    private static void safeSoftReferenceExample() throws InterruptedException {
        System.out.println("=== Пример работы с SoftReference (мягкие ссылки) ===");
        Object heavyData = new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("Вызван метод finalize() для объекта с мягкой ссылкой");
            }
        };
        SoftReference<Object> softRef = new SoftReference<>(heavyData);
        heavyData = null;

        System.gc();
        TimeUnit.MILLISECONDS.sleep(100);

        Object data = softRef.get();
        if (data != null) {
            System.out.println("Объект доступен через мягкую ссылку: " + data);
        } else {
            System.out.println("Объект уже удалён сборщиком мусора");
        }
    }

    private static void safeWeakReferenceExample() throws InterruptedException {
        System.out.println("\n=== Пример работы с WeakReference (слабые ссылки) ===");
        Object cacheEntry = new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("Вызван метод finalize() для объекта со слабой ссылкой");
            }
        };
        WeakReference<Object> weakRef = new WeakReference<>(cacheEntry);
        Object entry = weakRef.get();
        cacheEntry = null;


        System.gc();
        TimeUnit.MILLISECONDS.sleep(100);

        if (entry != null) {
            System.out.println("Объект доступен через слабую ссылку: " + entry);
        } else {
            System.out.println("Объект уже удалён сборщиком мусора (ожидаемое поведение для WeakReference)");
        }
    }
}