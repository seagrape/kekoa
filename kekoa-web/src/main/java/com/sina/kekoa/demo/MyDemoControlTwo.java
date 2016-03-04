package com.sina.kekoa.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/two")
public class MyDemoControlTwo {

	@RequestMapping("/")
    public String index() {
        return "Hello World 2!";
    }
}
