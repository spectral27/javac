package spc;

public class Main {
    public static void main(String[] args) {
        String vendor = Vendor.getVendor();
        Version versionObject = new Version();
        String version = versionObject.getVersion();
        System.out.printf("%s %s\n", vendor, version);
    }
}
