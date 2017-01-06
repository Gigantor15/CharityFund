package dataTier;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beans.Organization;
import java.util.List;

public class OrganizationDAO {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Organization get(int id) {
		return (Organization) sessionFactory.openSession().get(Organization.class, id);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Organization load(int id) {
		return (Organization) sessionFactory.openSession().load(Organization.class, id);
	}
        
        @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
        public List<Organization> getAll(){
            return sessionFactory.openSession().createCriteria(Organization.class).list();
        }

}
