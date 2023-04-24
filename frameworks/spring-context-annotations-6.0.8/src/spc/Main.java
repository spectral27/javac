package spc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        JavaObject java = new JavaObject();
        java.setVendor(System.getProperty("java.vendor"));
        java.setVersion(System.getProperty("java.version"));

        JavaObject spring = new JavaObject();
        spring.setVendor("Spring Framework");
        spring.setVersion("6.0.8");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TaskAssigner taskAssigner = context.getBean(TaskAssigner.class);
        taskAssigner.print(java);
        taskAssigner.print(spring);
        context.close();
    }

}
