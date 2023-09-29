package spec;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Component;

@Component
public class TaskResolver {
    
    public void print() {
        String version = null;
        try {
            version = Files.readString(Path.of("version.txt"));
        } catch (IOException e) {
            System.out.println(String.format("%s: %s", e.getClass().getName(), e.getMessage()));
        }
        System.out.println(String.format("%s %s", "Spring", version));
    }

}
