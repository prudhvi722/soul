package comm.example.service;

import comm.example.model.OfficeTask;

import java.util.Optional;

public interface OfficeTaskService {
    public Iterable<OfficeTask> findAllOfficeTasks();
    public Optional<OfficeTask> findOfficeTaskById(int Id);
    public OfficeTask createAndUpdateOfficeTask(OfficeTask officeTask);
    public void deleteOfficeTask(OfficeTask officeTask);
    public void deleteOfficeTaskById(int Id);
}
