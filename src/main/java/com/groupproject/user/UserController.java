package com.groupproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/me")
    public String welcome() {
        return "index";
    }

    @PutMapping
    public UserDto register(@ModelAttribute UserRegistrationDto dto) {
        return userService.register(dto);
    }
}
