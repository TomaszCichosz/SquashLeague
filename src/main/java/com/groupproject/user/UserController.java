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

    @PostMapping
    @ResponseBody
    public UserDto createUser(@RequestBody UserCreateDto userCreateDto) {
        return userService.create(userCreateDto);
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
}
