package spc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskAssigner {
    
    @Autowired
    private ObjectPrinter objectPrinter;

    public void print(JavaObject javaObject) {
        objectPrinter.print(javaObject);
    }

}
