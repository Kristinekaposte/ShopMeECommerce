package com.shopMeECommerce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {

    @GetMapping("/home")
    public String viewHomePage() throws Exception{

        return "indexAdmin.html";
    }

    @GetMapping("")
    public String viewIndexPage() throws Exception{
        return "index.html";
    }
}
