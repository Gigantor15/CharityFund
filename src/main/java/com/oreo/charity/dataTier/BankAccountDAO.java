package com.oreo.charity.dataTier;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oreo.charity.beans.BankAccount;

public class BankAccountDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public BankAccount get(int id) {
		return (BankAccount) sessionFactory.getCurrentSession().get(BankAccount.class, id);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public BankAccount load(int id) {
		return (BankAccount) sessionFactory.getCurrentSession().load(BankAccount.class, id);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insert(BankAccount account){
		sessionFactory.getCurrentSession().save(account);
	}
	
}
