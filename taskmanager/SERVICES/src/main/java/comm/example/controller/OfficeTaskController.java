package comm.example.controller;

import comm.example.model.OfficeTask;
import comm.example.service.OfficeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OfficeTaskController {
    private OfficeTaskService officeTaskService;
@Autowired
    public OfficeTaskController(OfficeTaskService officeTaskService) {
        this.officeTaskService = officeTaskService;
    }
    @GetMapping(value = {"/officeTasks"},produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<OfficeTask>> getAllOfficeTasks()
    {
        return ResponseEntity.status(HttpStatus.OK).body(officeTaskService.findAllOfficeTasks());
    }
    @GetMapping(value = "/officeTasks/{officeTaskId}",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<OfficeTask>> getOfficeTasksById(@PathVariable("officeTaskId") int Id){
    return ResponseEntity.status(HttpStatus.OK).body(officeTaskService.findOfficeTaskById(Id));
    }
    @PostMapping("/officeTasks")
    public ResponseEntity<OfficeTask> createOfficeTask(@Valid @RequestBody OfficeTask officeTask)
    {

        return ResponseEntity.status(HttpStatus.OK).body(officeTaskService.createAndUpdateOfficeTask(officeTask));
    }
    @PutMapping("/officeTasks")
    public ResponseEntity<OfficeTask> updateOfficeTask(@Valid @RequestBody OfficeTask officeTask)
    {
        return ResponseEntity.status(HttpStatus.OK).body(officeTaskService.createAndUpdateOfficeTask(officeTask));
    }
    @DeleteMapping("/officeTasks")
    public ResponseEntity<String> deleteOfficeTask(@RequestBody OfficeTask officeTask)
    {
        officeTaskService.deleteOfficeTask(officeTask);
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
    }
    @DeleteMapping("/officeTasks/{taskId}")
    public ResponseEntity<String> deleteOfficeTaskById(@PathVariable("taskId") int Id)
    {
        officeTaskService.deleteOfficeTaskById(Id);
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
    }
}
