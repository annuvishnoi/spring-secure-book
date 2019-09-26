package com.training.secure.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.secure.model.Authorithy;
import com.training.secure.model.RolesIdentity;
import com.training.secure.model.User;



@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void registerUser(User user) {
		Session session= this.sessionFactory.getCurrentSession();
		user.setEnabled(1);
		session.saveOrUpdate(user);
		RolesIdentity rolesIdentity = new RolesIdentity();
		rolesIdentity.setUserName(user.getUserName());
		rolesIdentity.setAuthority(user.getRole());
		Authorithy authorithy = new Authorithy();
		authorithy.setRolesIdentity(rolesIdentity);
		session.saveOrUpdate(authorithy);
		System.out.println("User added successfully." + user);

	}
}

