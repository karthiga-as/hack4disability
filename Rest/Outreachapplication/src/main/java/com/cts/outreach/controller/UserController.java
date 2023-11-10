package com.cts.outreach.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.outreach.exceptions.UserAlreadyExistsException;
import com.cts.outreach.exceptions.UserNotFoundException;
import com.cts.outreach.model.User;
import com.cts.outreach.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@RequestMapping(value = "/api/userService")
public class UserController {

	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@ApiOperation(value = "Get all Users", response = Iterable.class)
	@GetMapping("/getUserList")
	public ResponseEntity<?> getAllUsers() throws UserNotFoundException {
		List<User> userlist;
		try {
			userlist = userService.getAllUsers();
			return new ResponseEntity<>(userlist, HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "Register User")
	@PostMapping("/user")
	public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
		User userObj;
		try {
			userObj = userService.registerUser(user);
			return new ResponseEntity<>(userObj, HttpStatus.CREATED);
		} catch (UserAlreadyExistsException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@ApiOperation(value = "Update User")
	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("id") String userId) throws Exception {
		try {
			User userval = userService.updateUser(userId, user);
			return new ResponseEntity<>(userval, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Delete User")
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") String userId) throws UserNotFoundException {
		try {
			boolean status = userService.deleteUser(userId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Get User Details")
	@GetMapping("/user/{id}")
	public ResponseEntity<?> fetchUserDetails(@PathVariable String id) throws UserNotFoundException {
		try {
			User userInfo = userService.getUserById(id);
			return new ResponseEntity<>(userInfo, HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
