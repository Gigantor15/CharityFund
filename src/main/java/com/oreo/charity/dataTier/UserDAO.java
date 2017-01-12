package com.oreo.charity.dataTier;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oreo.charity.beans.User;

@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User get(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public User load(int id) {
		return (User) sessionFactory.getCurrentSession().load(User.class, id);
	}
	
	public void update( User user){
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
}
