package com.example.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class AngularController implements ErrorController {
	
	private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "forward:/index.html";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
