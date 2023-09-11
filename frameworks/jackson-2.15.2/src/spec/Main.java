package spec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public class Processor {
        public String model;
    }

    public static void main(String[] args) {
        Processor processor = new Main().new Processor();
        processor.model = "i7-1165G7";

        ObjectMapper jackson = new ObjectMapper();
        String processorJson;
        try {
            processorJson = jackson.writerWithDefaultPrettyPrinter().writeValueAsString(processor);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(processorJson);
    }

}
