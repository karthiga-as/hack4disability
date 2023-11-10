package com.cts.outreach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.outreach.exceptions.UserAlreadyExistsException;
import com.cts.outreach.exceptions.UserNotFoundException;
import com.cts.outreach.model.User;
import com.cts.outreach.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepositroy;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepositroy = userRepository;
	}

	@Override
	public User registerUser(User user) throws UserAlreadyExistsException {
		User obj = userRepositroy.insert(user);
		if (obj != null) {
			return obj;
		} else {
			throw new UserAlreadyExistsException("user already exists");
		}
	}

	@Override
	public User updateUser(String userId, User user) throws UserNotFoundException {
		User userObj = userRepositroy.findById(userId).get();
		if (userObj != null) {
			userObj = userRepositroy.save(user);
			return user;
		} else {
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	public boolean deleteUser(String userId) throws UserNotFoundException {
		User userObj = userRepositroy.findById(userId).get();
		boolean userDeleted = false;
		if (userObj != null) {
			userRepositroy.delete(userObj);
			userDeleted = true;
		} else {
			throw new UserNotFoundException("User Not Found");
		}
		return userDeleted;
	}

	@Override
	public User getUserById(String userId) throws UserNotFoundException {
		User userObj = userRepositroy.findById(userId).get();
		if (userObj == null) {
			throw new UserNotFoundException("User Not Found");
		}
		return userObj;
	}

	@Override
	public List<User> getAllUsers() throws UserNotFoundException {
		List<User> userlist = userRepositroy.findAll();
		if (userlist == null) {
			throw new UserNotFoundException("No OutreachUsers available");
		}
		return userlist;
	}

}
