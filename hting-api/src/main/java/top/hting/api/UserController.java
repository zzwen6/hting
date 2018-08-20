package top.hting.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.hting.entity.UserEntity;
import top.hting.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/add")
	public UserEntity addUserEntity(@RequestBody UserEntity userEntity) {
		
		return userService.save(userEntity);
	}
	@GetMapping(value = "/findById")
	public UserEntity findById(@RequestParam Long id) {
		return userService.findById(id);
	}
	
	@GetMapping(value = "/get")
	public void get(@RequestParam Long id) {
		userService.findById(id);
	}
}
