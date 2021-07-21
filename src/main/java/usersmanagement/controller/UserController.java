package usersmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import usersmanagement.entity.User;
import usersmanagement.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user){
		User savedUser = userService.saveOrUpdate(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.FOUND).body(userService.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.FOUND).body(userService.getById(id));
	}
}
