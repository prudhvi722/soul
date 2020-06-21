package comm.example.service;

import comm.example.model.OfficeTask;
import comm.example.repository.OfficeTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("officeTaskService")
@EnableTransactionManagement
@EnableAutoConfiguration
public class OfficeTaskServiceImpl implements OfficeTaskService{
    private OfficeTaskRepository officeTaskRepository;
@Autowired
    public OfficeTaskServiceImpl(OfficeTaskRepository officeTaskRepository) {
        this.officeTaskRepository = officeTaskRepository;
    }

    @Override
    @Transactional
    public Iterable<OfficeTask> findAllOfficeTasks() {
        return officeTaskRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<OfficeTask> findOfficeTaskById(int Id) {
        return officeTaskRepository.findById(Id);
    }

    @Override
    @Transactional
    public OfficeTask createAndUpdateOfficeTask(OfficeTask officeTask) {
        return officeTaskRepository.save(officeTask);
    }

    @Override
    @Transactional
    public void deleteOfficeTask(OfficeTask officeTask) {
    officeTaskRepository.delete(officeTask);
    }

    @Override
    @Transactional
    public void deleteOfficeTaskById(int Id) {
officeTaskRepository.deleteById(Id);
    }
}
