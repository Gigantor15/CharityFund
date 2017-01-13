package com.oreo.charity.dataTier;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oreo.charity.beans.Donation;
import com.oreo.charity.beans.Event;
import com.oreo.charity.beans.User;
import java.util.ArrayList;

import java.util.List;
import org.hibernate.criterion.Restrictions;

public class DonationDAO {
	private SessionFactory sessionFactory;
        private User user;
        private Event event;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Donation get(int id) {
		return (Donation) sessionFactory.getCurrentSession().get(Donation.class, id);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Donation load(int id) {
		return (Donation) sessionFactory.getCurrentSession().load(Donation.class, id);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Donation> getMadeBy(User user) {
		return sessionFactory.getCurrentSession().createCriteria(Donation.class).add(Restrictions.eq("id", user.getId())).list();
	}
        
        @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
        public List<Donation> getMadeTo(Event event){
            return sessionFactory.getCurrentSession().createCriteria(Donation.class).add(Restrictions.eq("receiverId", event)).list();
        }
        
        @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
        public Double sumOfDonations(Event event){
                // ArrayList<Donation> total = new ArrayList<>();
                List<Donation> donList = sessionFactory.getCurrentSession().createCriteria(Donation.class).list();
                 double sum=0.0; 
                  
            for (int i = 0; i < donList.size() ; i++)  
            {  
                 Donation donation = donList.get(i);
                 if (event.getEventId() == donation.getDoantionId()){
                    System.out.println();  
                    sum += donation.getDonationAmount();  
                 }
             }  
            
            System.out.println(sum);
             return sum;
        }
                
        
        @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
        public List<Donation> getAllDonations(){
            return sessionFactory.getCurrentSession().createCriteria(Donation.class).list();
        }


}
