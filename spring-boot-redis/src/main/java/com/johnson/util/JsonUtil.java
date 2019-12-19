package com.johnson.util;

import com.google.gson.Gson;

/**
 * @author johnson lin
 * @date 2019/12/19 2:12 PM
 */
public final class JsonUtil {
    private JsonUtil() {
    }

    private static Gson gson = new Gson();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
