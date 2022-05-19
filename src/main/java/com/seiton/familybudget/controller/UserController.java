package com.seiton.familybudget.controller;

import com.seiton.familybudget.model.User;
import com.seiton.familybudget.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/telegramm")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") long id){
        return userService.getUser(id);
    }

    @PostMapping("/user/new")
    public long addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable("id") long id, @Valid @RequestBody User user){
        userService.updateUser(id, user);
    }
}
