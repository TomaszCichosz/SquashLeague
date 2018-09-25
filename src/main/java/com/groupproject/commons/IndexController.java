package com.groupproject.commons;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    String view() {
        return "index";
    }

    @GetMapping("/index")
    String index() {
        return "index";
    }

    @GetMapping("/index/error")
    String error(Model model){
        model.addAttribute("msg","Wrong login or password");
        return "index";
    }
}
