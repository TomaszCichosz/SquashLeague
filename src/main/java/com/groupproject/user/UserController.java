package com.groupproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/users")
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

    @PostMapping("/{uuid}")
    @ResponseBody
    public void deleteUser(@PathVariable String uuid) {
        userService.deletedAsTrue(uuid);
    }

    @GetMapping("/home")
    public String welcome(Model model) {
        model.addAttribute("name",SecurityContextHolder.getContext().getAuthentication().getName());
        return "home";
    }

    @PutMapping("/index")
    public String register(@ModelAttribute UserRegistrationDto dto) {
        userService.register(dto);
        return "index";
    }

    @GetMapping("adduser")
    public String addUserView(Model model) {
        model.addAttribute("dto", new UserRegistrationDto());
        return "adduser";
    }

    @GetMapping("/logout")
    public String logoutUser(){
        SecurityContextHolder.clearContext();
        return "index";
    }
}
