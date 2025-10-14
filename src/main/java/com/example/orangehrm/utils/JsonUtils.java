package com.example.orangehrm.utils;

import com.example.orangehrm.models.UserData;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.List;

public class JsonUtils {
    public static List<UserData> readUsers(String relativePath) throws Exception {
        String path = Paths.get(relativePath).toAbsolutePath().toString();
        FileReader fr = new FileReader(path);
        Gson gson = new Gson();
        JsonObject root = gson.fromJson(fr, JsonObject.class);
        Type listType = new TypeToken<List<UserData>>(){}.getType();
        List<UserData> users = gson.fromJson(root.getAsJsonArray("users"), listType);
        fr.close();
        return users;
    }
}
