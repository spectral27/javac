package spec;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringBeans.class);
        TaskAssigner taskAssigner = context.getBean(TaskAssigner.class);
        taskAssigner.print();
        context.close();
    }

}
