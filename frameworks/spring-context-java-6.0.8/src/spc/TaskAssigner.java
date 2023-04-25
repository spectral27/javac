package spc;

public class TaskAssigner {
    
    private final ObjectPrinter objectPrinter;

    public TaskAssigner(ObjectPrinter objectPrinter) {
        this.objectPrinter = objectPrinter;
    }

    public void print(JavaObject javaObject) {
        objectPrinter.print(javaObject);
    }

}
