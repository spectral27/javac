package spec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskAssigner {
    
    @Autowired
    private TaskResolver taskResolver;

    public void print() {
        taskResolver.print();
    }

}
