package JUnitTest;

import java.sql.Timestamp;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oreo.charity.beans.BankAccount;
import com.oreo.charity.beans.Donation;
import com.oreo.charity.beans.Event;
import com.oreo.charity.beans.Organization;
import com.oreo.charity.beans.OrganizationType;
import com.oreo.charity.beans.User;
import com.oreo.charity.beans.UserRole;
import com.oreo.charity.dataTier.BankAccountDAO;
import com.oreo.charity.dataTier.DataFacade;
import com.oreo.charity.dataTier.DonationDAO;
import com.oreo.charity.dataTier.EventDAO;
import com.oreo.charity.dataTier.OrganizationDAO;
import com.oreo.charity.dataTier.OrganizationTypeDAO;
import com.oreo.charity.dataTier.UserDAO;
import com.oreo.charity.dataTier.UserRoleDAO;

public class NewHibernateTest {

	private static ApplicationContext contxt;

	@BeforeClass
	public static void setup() {
		contxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Test
	@Ignore
	public void createEvent() {

	Organization org = contxt.getBean(OrganizationDAO.class).get(1);

	Timestamp startDate = new Timestamp(System.currentTimeMillis());
	Timestamp endDate = Timestamp.valueOf("2017-01-15 1:10:10.0");
	Event event = new Event(7, "Skin Cancer", "stay indoors", startDate, endDate, 10000, org);
	contxt.getBean(DataFacade.class).createEvent(event);
	System.out.println("Event was created!");
	}
	
	
	@Test
	@Ignore
	public void testAssignNewBankAccount(){
		BankAccount userBank= contxt.getBean(BankAccountDAO.class).get(3);
		System.out.println(userBank);
		User user = contxt.getBean(UserDAO.class).get(11);
		System.out.println(user);
		user.setBankAccount(userBank);
		contxt.getBean(UserDAO.class).update(user);
	}

	@Test
	@Ignore
	public void testBankAccountInsert() {
		BankAccount account = new BankAccount(3, 123456889, 111111111, 50000.00);
		contxt.getBean(DataFacade.class).insertBankAccount(account);
		System.out.println("success");
	}

	@Test
	@Ignore
	public void testFacade() {
		System.out.println(contxt.getBean(DataFacade.class).getBankAccount());
		System.out.println(contxt.getBean(DataFacade.class).getDonation());
		System.out.println(contxt.getBean(DataFacade.class).getEvent());
		System.out.println(contxt.getBean(DataFacade.class).getOrganization());
		System.out.println(contxt.getBean(DataFacade.class).getOrganizationType());
		System.out.println(contxt.getBean(DataFacade.class).getUser());
		System.out.println(contxt.getBean(DataFacade.class).getUserRole());
	}

	@Test
	@Ignore
	public void testGetFromEveryTable() {

		BankAccount bean1 = contxt.getBean(BankAccountDAO.class).get(1);
		OrganizationType bean6 = contxt.getBean(OrganizationTypeDAO.class).get(1);
		UserRole bean2 = contxt.getBean(UserRoleDAO.class).get(1);
		Donation bean3 = contxt.getBean(DonationDAO.class).get(1);
		Event bean4 = contxt.getBean(EventDAO.class).get(1);
		Organization bean5 = contxt.getBean(OrganizationDAO.class).get(1);
		User bean7 = contxt.getBean(UserDAO.class).get(1);

		System.out.println(bean1);
		System.out.println(bean6);
		System.out.println(bean2);
		System.out.println(bean3);
		System.out.println(bean4);
		System.out.println(bean5);
		System.out.println(bean7);
	}
}
