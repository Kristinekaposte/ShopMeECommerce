package com.shopMeECommerce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainECommerceController {
    @GetMapping("")
    public String viewHomePage() throws Exception{
        return "index.html";
    }
}
