package com.cts.outreach.service;

import java.util.List;

import com.cts.outreach.exceptions.UserAlreadyExistsException;

import com.cts.outreach.exceptions.UserNotFoundException;

import com.cts.outreach.model.User;

public interface UserService {

	User registerUser(User user) throws UserAlreadyExistsException;

	User updateUser(String userId, User user) throws UserNotFoundException;

	boolean deleteUser(String userId) throws UserNotFoundException;

	User getUserById(String userId) throws UserNotFoundException;

	List<User> getAllUsers() throws UserNotFoundException;

}
