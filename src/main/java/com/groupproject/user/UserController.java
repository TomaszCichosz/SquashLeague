package com.groupproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody
    public List<UserDto> findAllUsers() {
        return userService.findAll();
    }


    @GetMapping("/delete")
    public String deleteView(Model model) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        String uuid = userService.findOneByLogin(login).getUuid();
        model.addAttribute("uuid", uuid);
        return "delete";
    }

    @PostMapping("/delete/{uuid}")
    public String deleteUser(@PathVariable String uuid) {
        userService.deletedAsTrue(uuid);
        return "index";
    }

    @GetMapping("/home")
    public String welcome(Model model) {
        model.addAttribute("name", SecurityContextHolder.getContext().getAuthentication().getName());
        return "home";
    }

    @PutMapping("/index")
    public String register(@ModelAttribute UserRegistrationDto dto,Model model) {
        if( userService.checkIfLoginExist(dto.getLogin())){
            model.addAttribute("dto", new UserRegistrationDto());
            model.addAttribute("message","User already exists");
            return "adduser";
        }
        if(dto.getLogin().length()<=4){
            model.addAttribute("dto", new UserRegistrationDto());
            model.addAttribute("message","Login must have min. 4 letters");
            return "adduser";
        }
        if(dto.getPassword().length()<=4){
            model.addAttribute("dto", new UserRegistrationDto());
            model.addAttribute("message","Password must have min. 4 letters");
            return "adduser";
        }
        userService.register(dto);
        return "index";
    }

    @GetMapping("/adduser")
    public String addUserView(Model model) {
        model.addAttribute("dto", new UserRegistrationDto());
        return "adduser";
    }

    @GetMapping("/logout")
    public String logoutUser() {
        SecurityContextHolder.clearContext();
        return "index";
    }
}
