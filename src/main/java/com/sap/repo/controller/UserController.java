package com.sap.repo.controller;

import com.sap.repo.models.LoginDetails;
import com.sap.repo.models.UserDetails;
import com.sap.repo.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<UserDetails> getHardCodedLoginDetails() {
        return this.userService.getUsers();
    }
}
