package comm.prudhvi.service;




import comm.prudhvi.dao.ToDoDAO;
import comm.prudhvi.model.ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("todoService")
public class ToDoServiceImpl implements ToDoService{
    private ToDoDAO toDoDAO;
    public ToDoServiceImpl(){

    }
    @Autowired
    public ToDoServiceImpl(ToDoDAO toDoDAO) {
        this.toDoDAO=toDoDAO;
    }
    @Override
    public List<ToDo> getToDo() {


        return toDoDAO.getToDo();
    }
    @Override
    public void createToDo(ToDo todo) {

        toDoDAO.createToDo(todo);

    }

    @Override
    public ToDo geToDo(int todoId) {
        return toDoDAO.geToDo(todoId);
    }

    @Override

    public void deleteToDo(int todoId) {
        toDoDAO.deleteToDo(todoId);
    }
}
