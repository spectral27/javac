package spc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        JavaObject javaObject = new JavaObject();
        javaObject.setVendor(System.getProperty("java.vendor"));
        javaObject.setVersion(System.getProperty("java.version"));
        ObjectMapper jackson = new ObjectMapper();
        String json = new String();
        try {
            json = jackson.writerWithDefaultPrettyPrinter()
                .writeValueAsString(javaObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }
}
