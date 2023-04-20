package spc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spc.model.JavaObject;
import spc.service.TestService;

public class Main {

    public static void main(String[] args) {
        JavaObject java = new JavaObject();
        java.setVendor(System.getProperty("java.vendor"));
        java.setVersion(System.getProperty("java.version"));
        JavaObject spring = new JavaObject();
        spring.setVendor("Spring Framework");
        spring.setVersion("6.0.8");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TestService testService = context.getBean(TestService.class);
        testService.printObject(java);
        testService.printObject(spring);
        context.close();
    }

}
