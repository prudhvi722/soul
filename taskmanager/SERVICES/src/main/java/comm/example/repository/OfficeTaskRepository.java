package comm.example.repository;

import comm.example.model.OfficeTask;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository
@EnableAutoConfiguration
@EnableTransactionManagement
public interface OfficeTaskRepository extends CrudRepository<OfficeTask,Integer> {
}
