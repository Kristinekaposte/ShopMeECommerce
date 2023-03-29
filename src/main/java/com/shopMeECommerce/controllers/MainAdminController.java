package com.shopMeECommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainAdminController {

    @GetMapping("/homeAdmin")
    public String viewHomePage() throws Exception{

        return "indexAdmin";
    }
}
