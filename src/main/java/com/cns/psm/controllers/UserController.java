package com.cns.psm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cns.psm.entities.User;
import com.cns.psm.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	@Autowired
	private UserService uSer;

	//====== all user =====
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> list = uSer.getAllUsers();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	//=========== single user=======
	
	@GetMapping("/{id}")
	public ResponseEntity<User>getSingleUser(@PathVariable("id")Integer id){
		User u = uSer.getUser(id).get();
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
}
