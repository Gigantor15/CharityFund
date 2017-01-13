package featureTest;

import java.sql.Timestamp;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oreo.charity.beans.Event;
import com.oreo.charity.beans.Organization;
import com.oreo.charity.dataTier.DataFacade;
import com.oreo.charity.dataTier.OrganizationDAO;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MakeEventTest {
	
	static int organizationId = 1;
	static String organization;
	static ApplicationContext contxt;
	
	@BeforeClass
	public static void setup() {
		contxt = new ClassPathXmlApplicationContext("beans.xml");
	}

	@Test
	@Given("^I have a charity organization$")
	public void i_have_a_charity_organization() throws Throwable {
		organization = contxt.getBean(DataFacade.class).getOrganization(organizationId).getOrganizationName();
	    if(organization!=null) System.out.println("The organization is " + organization);
	}

	@Test
	@When("^I make an event$")
	public void i_make_an_event() throws Throwable {
//		Organization org = contxt.getBean(OrganizationDAO.class).get(1);
//
//		Timestamp startDate = new Timestamp(System.currentTimeMillis());
//		Timestamp endDate = Timestamp.valueOf("2017-01-15 1:10:10.0");
//		Event event = new Event(5, "Test", "stay indoors", startDate, endDate, 10000, org);
//		contxt.getBean(DataFacade.class).createEvent(event);
//		System.out.println("Event "+ event.getEventName() +" was created!");
	}

	@Then("^I have new event listing on my homepage$")
	public void i_have_new_event_listing_on_my_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
