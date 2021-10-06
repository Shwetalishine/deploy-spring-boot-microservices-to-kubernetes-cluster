package com.app.user.controller;

import VO.ResponseTemplateVO;
import com.app.user.entity.User;
import com.app.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of User Controller ");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable ("id") String userId){
        log.info("Inside getUserWithDepartment of User Controller ");
        return userService.getUserWithDepartment(userId);
    }
}
