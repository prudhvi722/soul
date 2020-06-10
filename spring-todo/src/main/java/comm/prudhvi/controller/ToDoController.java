package comm.prudhvi.controller;

import comm.prudhvi.model.ToDo;
import comm.prudhvi.service.ToDoService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/todo")
public class ToDoController {

    private ToDoService toDoService;
    public ToDoController(ToDoService toDoService){
        this.toDoService= toDoService;
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,false));

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/listToDo")
    public String listToDo(Model model){
        model.addAttribute("todo",toDoService.getToDo());
        return "todo-list";

    }


    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
//        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
//        String datepicker = formatDate.format(toDo.getDatepicker());
//        toDo.setDatepicker(formatDate.parse(datepicker));
        model.addAttribute("todo",new ToDo());
        return "todo-form";

    }
    @RequestMapping("/saveCustomer")
    public String saveToDo(@ModelAttribute("todo") ToDo toDo)
    {
        toDoService.createToDo(toDo);
        return "redirect:/todo/listToDo";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("todoId") int theId,
                                    Model theModel) {

        ToDo thetodo = toDoService.geToDo(theId);

        // set customer as a model attribute to pre-populate the form
        theModel.addAttribute("todo", thetodo);

        // send over to our form
        return "todo-form";
    }
    @RequestMapping("/updateCustomer")
    public String updateToDO(@Valid @ModelAttribute("todo") ToDo toDo,
                             BindingResult theBindingResult ) {
        if (theBindingResult.hasErrors()) {
            return "todo-form";
        } else {
            toDoService.createToDo(toDo);
            return "redirect:/todo/listToDO";
        }
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam("todoId") int todoId)
    {
        toDoService.deleteToDo(todoId);
        return "redirect:/todo/listToDo";
    }
}
