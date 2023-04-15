public class Main {

    public static void main(String[] args) {
        JavaObject javaObject = new JavaObject();
        javaObject.setVendor(System.getProperty("java.vendor"));
        javaObject.setVersion(System.getProperty("java.version"));
        System.out.printf("%s %s\n", javaObject.getVendor(), javaObject.getVersion());
    }

}
