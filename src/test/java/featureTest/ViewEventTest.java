 package featureTest;

import com.oreo.charity.beans.*;
import com.oreo.charity.dataTier.DataFacade;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ViewEventTest {
    	static ApplicationContext contxt;
	static int userID = 1;
	static int eventID = 1;
        static int organizationID = 1;
        
	@BeforeClass
	public static void setup() {
          contxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
   @Test 
  @Given("^I have an event$")
public void i_have_an_event() throws Throwable {
    
    //set User and organization
    User user = contxt.getBean(DataFacade.class).getUser(userID);
    Organization organization = contxt.getBean(DataFacade.class).getOrganization(organizationID);
    
    //Set event
    Event event = contxt.getBean(DataFacade.class).getEvent(eventID);
    
    //Get userID and event mangerID
    int u_id = user.getId();
    int eventManager_id = event.getOrganizationId().getManagerId().getId();
    
    //Find userID == eventManger ID
    String fname = user.getFirstName();
    String eventName = event.getEventName();
    
    if (eventManager_id == u_id){
        System.out.println(fname + " has " + eventName);
    }else{
        System.out.println(fname + " doesn't have " + eventName);
    }
        
       Assert.assertNotNull(event);
}


@Given("^I check on the event (\\d+)$")
public void i_check_on_the_event(int arg1) throws Throwable {
    Event event = contxt.getBean(DataFacade.class).getEvent(arg1);
    double goal = event.getGoalAmount();
    
    String eventName = event.getEventName();
    
    System.out.println(eventName + " has a goal amount of " + goal);
    
    Assert.assertNotNull(goal);
}


@When("^I see how much has been (\\d+)$")
public void i_see_how_much_has_been(int arg1) throws Throwable {
//    
    
}


@Then("^I can view how much is (\\d+) until the goal$")
public void i_can_view_how_much_is_until_the_goal(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}


@Then("^I see the goal has nothing (\\d+)$")
public void i_see_the_goal_has_nothing(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}


@Then("^I see the goal has been (\\d+)$")
public void i_see_the_goal_has_been(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}  
}