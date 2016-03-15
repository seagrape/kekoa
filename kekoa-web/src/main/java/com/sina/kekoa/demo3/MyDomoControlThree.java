package com.sina.kekoa.demo3;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sina.kekoa.demo3.jdbc.Student;
import com.sina.kekoa.demo3.jdbc.StudentService;
import com.sina.kekoa.demo3.jpa.UserService;

@RestController
@RequestMapping("/three")
public class MyDomoControlThree {
	
	private static final Logger logger = LoggerFactory.getLogger(MyDomoControlThree.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private StudentService studentService;

	@RequestMapping("/")
    public String index() {
        return "Hello World 3 For DataBase!";
    }

	@RequestMapping("/jpa")
    //@RequiresRoles("admin") it works!
	@Transactional(readOnly = true)
	public String helloWorld() {
		return this.userService.getUser("Bath").getName();
	}
	
	@RequestMapping("/jdbc")
    public List<Student> getStus(){
        logger.info("从数据库读取Student集合");
        return studentService.getList();
    }
}
