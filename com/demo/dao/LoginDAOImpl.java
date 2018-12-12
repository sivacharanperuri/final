package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.entity.User;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(user);
	}

	@Override
	public User validateUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();

		user = currentSession.get(User.class, user.getUserName());
		System.out.println("LoginDAOImpl validateUser(User user)" + user);
		return user;
	}

}
