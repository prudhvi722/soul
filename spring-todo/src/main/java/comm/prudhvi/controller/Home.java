package comm.prudhvi.controller;


import org.springframework.stereotype.Controller;

@Controller
public class Home {
    private String home()
    {
        return "index";
    }
}
