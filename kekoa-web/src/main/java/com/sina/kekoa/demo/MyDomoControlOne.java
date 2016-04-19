package com.sina.kekoa.demo;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/")
public class MyDomoControlOne {
	
	@Value("${application.message:Hello World}")
	private String message = "Hello World";
//
//	@RequestMapping("/")
//	@ResponseBody
//    public String index() {
//        return "Hello World 1!";
//    }

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		System.out.println(message);
		return "welcome";
	}
}
