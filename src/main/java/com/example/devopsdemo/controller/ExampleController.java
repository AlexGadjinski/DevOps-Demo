package com.example.devopsdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ExampleController {

    @GetMapping
    public ModelAndView getHomePage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        modelAndView.addObject("appName", "🚀 DevOps Demo v1.0");
        modelAndView.addObject("currentTime", LocalDateTime.now().toString());
        modelAndView.addObject("pipelineStatus", "SUCCESS");
        modelAndView.addObject("deployedVia", "GitHub Actions -> Docker -> Cloud");

        return modelAndView;
    }

    @GetMapping("/api/health")
    @ResponseBody
    public Map<String, String> healthCheck() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("service", "demo-app");
        return status;
    }
}
