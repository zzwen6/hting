package top.hting.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import top.hting.entity.primary.UserEntity;
import top.hting.service.UserService;

@Api(value = "用户管理", description = "用户管理")
@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/add")
	@ApiOperation(nickname = "新增用户", value = "新增用户")
	public UserEntity addUserEntity(@RequestBody @ApiParam(name = "用户对象") UserEntity userEntity) {
		
		return userService.save(userEntity);
	}
	@ApiOperation(nickname = "根据ID查询用户", value = "根据ID查询用户")
	@GetMapping(value = "/findById")
	public UserEntity findById(@RequestParam Long id) {
		return userService.findById(id);
	}
	@ApiOperation(nickname = "根据ID查询用户", value = "根据ID查询用户")
	@GetMapping(value = "/get")
	public void get(@RequestParam Long id) {
		// userService.findById(id);
		throw new RuntimeException("哈哈");
	}
}
