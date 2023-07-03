package spc;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ProcessorService {

    private final ProcessorRepository processorRepository;

    public ProcessorService(ProcessorRepository processorRepository) {
        this.processorRepository = processorRepository;
    }

    public void insert(Processor processor) {
        processorRepository.insert(processor);
    }

    public List<Processor> selectAll() {
        return processorRepository.selectAll();
    }

}
