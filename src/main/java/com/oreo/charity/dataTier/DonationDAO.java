package com.oreo.charity.dataTier;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oreo.charity.beans.Donation;

import java.util.List;
import org.hibernate.criterion.Restrictions;

public class DonationDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Donation get(int id) {
		return (Donation) sessionFactory.openSession().get(Donation.class, id);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Donation load(int id) {
		return (Donation) sessionFactory.openSession().load(Donation.class, id);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Donation> getMadeBy(int usersId) {
		return sessionFactory.openSession().createCriteria(Donation.class).add(Restrictions.eq("id", usersId)).list();
	}


}
