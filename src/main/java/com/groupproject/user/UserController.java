package com.groupproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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

    @PostMapping("/users/{uuid}")
    @ResponseBody
    public void deleteUser(@PathVariable String uuid) {
        userService.deletedAsTrue(uuid);
    }

    @GetMapping("/users/me")
    public String welcome() {
        return "index";
    }

    @PutMapping
    public UserDto register(@ModelAttribute UserRegistrationDto dto) {
        return userService.register(dto);
    }
}
