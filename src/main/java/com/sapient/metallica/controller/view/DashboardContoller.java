package com.sapient.metallica.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardContoller {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

}
