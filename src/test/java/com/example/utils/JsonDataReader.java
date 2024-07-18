package com.example.utils;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonDataReader {
    public static JSONObject getDataFromJson(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
