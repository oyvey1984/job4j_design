package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Pojo {
    public static void main(String[] args) {
        JSONObject jsonEngine = new JSONObject("{\"fuelBrand\":\"Diesel\", \"horsepower\":\"180\"}");

        List<String> list = new ArrayList<>();
        list.add("Length: 4697 mm");
        list.add("Width: 1882 mm");
        list.add("Height: 1655 mm");
        JSONArray jsonSizes = new JSONArray(list);

        final Kodiaq kodiaq = new Kodiaq(true, 188, "all wheel drive",
                new Engine("Diesel", 180),
                new String[]{"Length: 4697 mm", "Width: 1882 mm", "Height: 1655 mm"});

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("diesel", kodiaq.isDiesel());
        jsonObject.put("clearance", kodiaq.getClearance());
        jsonObject.put("wheelDrive", kodiaq.getWheelDrive());
        jsonObject.put("engine", jsonEngine);
        jsonObject.put("size", jsonSizes);

        System.out.println(jsonObject);
        System.out.println(new JSONObject(kodiaq));
    }
}