package featureTest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MakeDonationTest {
	
	int donateAmount;
	
	
	@Given("^user enter the amount of money to donate$")
	public void user_enter_the_amount_of_money_to_donate() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^user have enough money in my bank to donate$")
	public void user_have_enough_money_in_my_bank_to_donate() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user click donate$")
	public void user_click_donate() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^users bank amount will be subtracted by donated amount$")
	public void users_bank_amount_will_be_subtracted_by_donated_amount() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^events organization bank amount will be added by the donated amount$")
	public void events_organization_bank_amount_will_be_added_by_the_donated_amount() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
