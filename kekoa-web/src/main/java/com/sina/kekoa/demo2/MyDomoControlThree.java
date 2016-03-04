package com.sina.kekoa.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sina.kekoa.demo2.jpa.UserService;

@RestController
@RequestMapping("/three")
public class MyDomoControlThree {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/")
    public String index() {
        return "Hello World 3 For JPA!";
    }

	@RequestMapping("/db")
	@Transactional(readOnly = true)
	public String helloWorld() {
		return this.userService.getUser("Bath").getName();
	}
}
