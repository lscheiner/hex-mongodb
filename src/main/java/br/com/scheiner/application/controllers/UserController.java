package br.com.scheiner.application.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.scheiner.application.dtos.UserDto;
import br.com.scheiner.application.mapper.UserMapper;
import br.com.scheiner.domain.service.UserService;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Observed(name = "userController")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUsers(@RequestHeader Map<String, String> headers) {

		logger.info("Chamanda getAllUsers");
		
		return ResponseEntity.ok(UserMapper.MAPPER.toUserDto(userService.findAll()));
	}
	
	@PostMapping("/users")
	public ResponseEntity<Void> createUser(@RequestBody UserDto userDto,
			@RequestHeader Map<String, String> headers) {

		logger.info("Chamanda create user {}", userDto);
		
		this.userService.save(UserMapper.MAPPER.toUser(userDto));
		
		return ResponseEntity.noContent().build();
	}

}
