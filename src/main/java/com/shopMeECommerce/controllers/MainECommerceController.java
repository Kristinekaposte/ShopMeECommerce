package com.shopMeECommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class MainECommerceController {
 //   @ResponseBody
    @GetMapping("/")
    public String viewHomePage() throws Exception{

       return "redirect:homeAdmin";

    }

    @GetMapping("/login")
    public String viewLoginPage() throws Exception{
        return "login";
    }
}
