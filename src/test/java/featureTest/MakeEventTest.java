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
	static String event;
	static ApplicationContext contxt;
	static int eventId = 1;
	static int eventId2 = 6; //change to whatever the new event you insert is
	
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
		Organization org = contxt.getBean(OrganizationDAO.class).get(1);

		Timestamp startDate = new Timestamp(System.currentTimeMillis());
		Timestamp endDate = Timestamp.valueOf("2017-01-15 1:10:10.0");
		Event event = new Event(6, "Bang Bang Bang", "No sleep gang", startDate, endDate, 10000, org);
		contxt.getBean(DataFacade.class).createEvent(event);
		System.out.println("Event "+ event.getEventName() +" whose cause is" + event.getDescription() +" was created!");
	}

	@Test
	@Then("^I have new event listing on my homepage$")
	public void i_have_new_event_listing_on_my_homepage() throws Throwable {
	    event = contxt.getBean(DataFacade.class).getEvent(eventId2).getEventName();
	    if(event!=null) System.out.println("The event is " + event);
	}
}
