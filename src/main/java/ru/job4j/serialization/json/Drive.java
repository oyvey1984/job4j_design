package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Drive {
    public static void main(String[] args) {
        final Kodiaq kodiaq = new Kodiaq(true, 188, "all wheel drive",
                new Engine("Diesel", 180), new String[]{"Length: 4697 mm", "Width: 1882 mm", "Height: 1655 mm"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(kodiaq));

        final String kodiaqJson =
                "{"
                        + "\"diesel\":false,"
                        + "\"clearance\":190,"
                        + "\"wheelDrive\":\"All wheel drive\","
                        + "\"engine\":"
                        + "{"
                        + "\"fuelBrand\":\"AI 95\","
                        + "\"horsepower\":\"150\""
                        + "},"
                        + "\"size\":"
                        + "[\"Length: 4700 mm\",\"Width: 1900 mm\",\"Height: 1700 mm\"]"
                        + "}";

        final Kodiaq kodiaqMod = gson.fromJson(kodiaqJson, Kodiaq.class);
        System.out.println(kodiaqMod);
    }
}