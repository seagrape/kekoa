package com.sina.kekoa.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/one")
public class MyDomoControlOne {

	@RequestMapping("/")
    public String index() {
        return "Hello World 1!";
    }
}
