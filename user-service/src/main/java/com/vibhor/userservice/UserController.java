package com.vibhor.userservice;


import com.vibhor.userservice.model.User;
import com.vibhor.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "ok";

    }
}
