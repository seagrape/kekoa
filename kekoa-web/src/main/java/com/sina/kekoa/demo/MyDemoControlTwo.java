package com.sina.kekoa.demo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sina.kekoa.config.Shanhy;

@RestController
@RequestMapping("/two")
public class MyDemoControlTwo {

	@Resource(name="shanhyA")
    private Shanhy shanhyA;

    @Autowired
    @Qualifier("shanhyB")
    private Shanhy shanhyB;
    
	@RequestMapping("/")
    public String index() {
        return "Hello World 2 for Java Code Bean Definition!";
    }
}
