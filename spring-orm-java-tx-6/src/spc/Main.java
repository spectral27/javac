package spc;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringBeans.class);

        Processor processor = new Processor();
        processor.setId("i7-1165G7");
        processor.setCodename("Tiger Lake");

        ProcessorService service = context.getBean(ProcessorService.class);
        service.insert(processor);

        List<Processor> processors = service.selectAll();
        processors.forEach(p -> System.out.printf("%s %s\n", p.getId(), p.getCodename()));

        context.close();
    }

}
