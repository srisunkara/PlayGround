package com.srisun.pg.utils;

import javax.json.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class JSONArray {

    public static void main(String[] args) {
        try {
            String filePath = "/Users/srini/Documents/Workspaces/Java_Projects/PlayGround/src/main/resources/sample.json";
            JSONArray.test(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void test(String filePath) throws FileNotFoundException {
        JsonReader reader = Json.createReader(new FileInputStream(filePath));
        //        JsonObject jsonObject = reader.readObject();
        //        String name = jsonObject.getString("name");
        //        JsonArray jsonArray = jsonObject.getJsonArray("arrayName");

        JsonArray jsonArray = reader.readArray();
        reader.close();


        for (JsonValue value : jsonArray) {
            JsonObject nestedObject = (JsonObject) value;
            // Access nested object properties
            System.out.println(nestedObject.get("name"));
            System.out.println(nestedObject.get("location"));
            JsonObject location  = (JsonObject) nestedObject.get("location");
            System.out.println(location.get("state"));
        }
    }
}
