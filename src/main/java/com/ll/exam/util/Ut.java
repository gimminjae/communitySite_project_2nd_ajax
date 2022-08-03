package com.ll.exam.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Ut {
    public static class json {
        private static ObjectMapper om;
        static {
            om = new ObjectMapper();
        }
        public static <T> T toObj(String json, Class<T> c, T defaultValue) {
            try {
                return om.readValue(json, c);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }

        public static <T> List<T> toObj(String jsonStr, TypeReference<List<T>> typeReference, List<T> defaultValue) {
            try {
                return om.readValue(jsonStr, typeReference);
            } catch(JsonProcessingException e) {
                return defaultValue;
            }
        }
        public static <T> String toJsonStr(T obj, String defaultValue) {
            try {
                return om.writeValueAsString(obj);
            } catch(JsonProcessingException e) {
                return defaultValue;
            }
        }
    }
}
