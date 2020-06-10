package comm.prudhvi.dao;

import comm.prudhvi.model.ToDo;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Repository("todoDAO")
public class ToDoDAOImpl implements ToDoDAO{
    private final EntityManager entityManager;
    @Autowired
    public ToDoDAOImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public List<ToDo> getToDo() {
        Query query = entityManager.createQuery(" from ToDo ");

        return query.getResultList();
    }

    @Override
    @Transactional
    public void createToDo(ToDo todo) {
        Session session = entityManager.unwrap(org.hibernate.Session.class);

        session.saveOrUpdate(todo);
    }

    @Override
    @Transactional
    public ToDo geToDo(int todoId) {
        return entityManager.find(ToDo.class,todoId);
    }


    @Override
    @Transactional
    public void deleteToDo(int todoId) {
        entityManager.remove(geToDo(todoId));
    }
}
