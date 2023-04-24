package spc;

import org.springframework.stereotype.Component;

@Component
public class ObjectPrinter {
    
    public void print(JavaObject javaObject) {
        System.out.printf("%s %s\n", javaObject.getVendor(), javaObject.getVersion());
    }

}
