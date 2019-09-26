package com.training.secure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.secure.dao.UserDAO;
import com.training.secure.model.User;

@Service
public class UserServiceImpl implements UserService{


	
	@Autowired
	UserDAO userDao;

	public void registerUser(User user) {
		userDao.registerUser(user);
	}
}
