package top.hting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import top.hting.entity.UserEntity;
import top.hting.jpa.UserJPA;

@Service
public class UserService {

	@Autowired
	UserJPA userJPA;
	@CachePut(value = "userEntity", key = "#user.id")
	public UserEntity save(UserEntity user) {
		return userJPA.save(user);
	}
	
	@Cacheable(value = "userEntity",key = "#id")
	public UserEntity findById(Long id) {
	 	return userJPA.findOne(id);
	}
	
}
