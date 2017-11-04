package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {
    @Value("${application.message:Hello Word!!}")
    private String message = "Hello world !!!";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model)
    {
        System.out.println("o");
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";

    }

    @RequestMapping("/welcome/{name}")
    public ModelAndView welcomeName(Map<String, Object> model, @PathVariable(value="name") final String name) {
        model.put("message", name);
        return new ModelAndView("/welcome", model);
    }


}
