package com.calmpet.user.controller;

import com.calmpet.user.entity.User;
import com.calmpet.user.service.UserService;
import com.calmpet.user.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calmpet")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/findAll")
    public Result getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user/addUser")
    public Result addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/user/updateUser")
    public Result updateUser(@RequestBody User user) {
        return  userService.updateUser(user);
    }

    @DeleteMapping("/user/deleteUser")
    public Result removeUser(@RequestBody User user) {
        return userService.removeUser(user);
    }

    @GetMapping("/user")
    public Result getUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        return Result.success(userService.login(username, password));
    }

}
