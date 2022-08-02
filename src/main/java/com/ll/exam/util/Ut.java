package com.ll.exam.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ut {
    public static class json {
        private static ObjectMapper om;
        static {
            om = new ObjectMapper();
        }
        public static <T> T toObj(String json, Class<T> c, T defaultValue) {
            try {
                return (T)om.readValue(json, c);
            } catch(JsonProcessingException e) {
                return defaultValue;
            }
        }
        public static String toJsonStr(Object obj, String defaultValue) {
            try {
                return om.writeValueAsString(obj);
            } catch(JsonProcessingException e) {
                return defaultValue;
            }
        }
    }
}
