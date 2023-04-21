package spc.service;

import spc.model.JavaObject;

public class TestService {
    
    public void printObject(JavaObject javaObject) {
        System.out.printf("%s %s\n", javaObject.getVendor(), javaObject.getVersion());
    }

}
