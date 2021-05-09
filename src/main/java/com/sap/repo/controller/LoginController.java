package com.sap.repo.controller;

import com.sap.repo.models.LoginDetails;
import com.sap.repo.services.LoginService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logins/")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public List<LoginDetails> getHardCodedLoginDetails() {
        return this.loginService.getLogins();
    }


    /** Uncomment and use this get method for test purpose*/

//    @GetMapping("/hardcodedlogin")
//    public LoginDetails getLoginDetails(){
//        LoginDetails hardcodedvalue = new LoginDetails();
//        hardcodedvalue.setUsername("sarthak");
//        hardcodedvalue.setPasscode("abcde");
//        return hardcodedvalue;
//    }

    @PostMapping("/login")
    public LoginDetails createLoginDetails(@RequestBody LoginDetails loginDetails) {
        return this.loginService.createLoginDetails(loginDetails);
    }
}
