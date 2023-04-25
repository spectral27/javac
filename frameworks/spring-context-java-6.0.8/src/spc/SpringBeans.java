package spc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeans {

    @Bean
    public ObjectPrinter objectPrinter() {
        return new ObjectPrinter();
    }

    @Bean
    public TaskAssigner taskAssigner(ObjectPrinter objectPrinter) {
        return new TaskAssigner(objectPrinter);
    }

}
