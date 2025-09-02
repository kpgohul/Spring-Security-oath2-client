package com.gohul.Oath2Client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MVCController {

    @RequestMapping("/securePage")
    public ModelAndView getSecurePage()
    {
        return new ModelAndView("secured.html");
    }
}
