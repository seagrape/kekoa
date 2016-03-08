package com.sina.kekoa.demo3.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Component("userService")
@Transactional
public class UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserJPA getUser(String name) {
		Assert.notNull(name, "Name must not be null");
		return this.userRepository.findByName(name);
	}
}
