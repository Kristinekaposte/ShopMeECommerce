package com.shopMeECommerce.controllers;

import com.shopMeECommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @Autowired
    private UserService service;
    @PostMapping("/homeAdmin/users/check_email")
    public String checkDuplicateEmail (@Param("email") String email){
        return service.isEmailUnique(email) ? "OK" : "Duplicated";
    }

}
