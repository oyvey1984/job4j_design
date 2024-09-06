package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class Binary {
    public static void main(String[] args) {
        int i = -5;
        System.out.println(Integer.toBinaryString(i));

        byte n = 27;
        n = (byte) (n << 1);
        System.out.println(n);

        int a = 6;
        int b = 4;

        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a: " + a + System.lineSeparator() + "b: " + b);

        int c = 5;
        int d = 9;
        c = c ^ d;
        d = c ^ d;
        c = c ^ d;

        System.out.println("c: " + c + System.lineSeparator() + "d: " + d);

        System.out.println(findNumberOfBits(12, 16));

        Map<Integer, String> map = new HashMap<>();
    }

    public static int findNumberOfBits(int x, int y) {
        int bitCount = 0;
        int z = x ^ y;
        System.out.println(z);
        while (z != 0) {
            bitCount += z & 1;
            z = z >> 1;
        }
        return bitCount;


    }
}