public class Main {
    public static void main(String[] args) {
        String vendor = System.getProperty("java.vendor");
        String version = System.getProperty("java.version");
        System.out.printf("%s %s\n", vendor, version);
    }
}
