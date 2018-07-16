package com.reve.plup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by reve on 7/16/2018.
 */
@RestController
public class TestCotroller {
    @GetMapping(value = "/index")
    ModelAndView tttt(){
        ModelAndView modelAndView = new ModelAndView("plup/upload");
        return modelAndView;
    }
}

