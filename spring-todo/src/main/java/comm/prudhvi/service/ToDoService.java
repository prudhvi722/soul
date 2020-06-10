package comm.prudhvi.service;

import comm.prudhvi.model.ToDo;

import java.util.List;

public interface ToDoService {


    public List<ToDo> getToDo();
    public void createToDo(ToDo todo);
    public ToDo geToDo(int todoId);
    public  void deleteToDo(int todoId);
}