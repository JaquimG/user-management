package usersmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import usersmanagement.dto.LoginWithEmailDTO;
import usersmanagement.dto.TokenDTO;
import usersmanagement.dto.UserDTO;
import usersmanagement.dto.UserOutputDTO;
import usersmanagement.serviceImpl.TokenService;
import usersmanagement.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO user){
		UserOutputDTO userOutput = userService.saveOrUpdate(user);
		return ResponseEntity.status(HttpStatus.OK).body(userOutput);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(userService.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PostMapping("/auth")
	public ResponseEntity<TokenDTO> auth(@RequestBody LoginWithEmailDTO loginDTO){
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword());
		
		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		String token = tokenService.generateToken(authentication);
		
		return ResponseEntity.ok(new TokenDTO(token));
		
	}
	
	
}
