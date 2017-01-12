package featureTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oreo.charity.beans.BankAccount;
import com.oreo.charity.dataTier.DataFacade;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MakeDonationTest {
	
	//given that user is logged in and on event page
	static int userId  = 1;
	static int eventId = 1;
	static ApplicationContext contxt;
	double donateAmount;
	
	double userStartBalance;
	double organizationStartBalance;
	
	@BeforeClass
	public static void setup() {
		contxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Before
	@Given("^user enter donation amount and has sufficient fund$")
	public void user_enter_donation_amount_and_has_sufficient_fund() throws Throwable {
		// user enters amount
		donateAmount = 10;
		
		// checks if user has sufficient fund
		userStartBalance = contxt.getBean(DataFacade.class).getUser(userId).getBankAccount().getBalance();
		organizationStartBalance = contxt.getBean(DataFacade.class).getEvent(eventId).getOrganizationId().getBankId().getBalance();
		
		System.out.println("user start balance: " + userStartBalance);
		System.out.println("Organization start balance: " + organizationStartBalance);
		
	}
	
	@Test
	@When("^user click donate$")
	public void user_click_donate() throws Throwable {
		// clicks donate
		
		// get the bank accounts involved
		BankAccount userBank = contxt.getBean(DataFacade.class).getUser(userId).getBankAccount();
		BankAccount organizationBank = contxt.getBean(DataFacade.class).getEvent(eventId).getOrganizationId().getBankId();
		
		// transfer the donation amount from user to event organization
		userBank.setBalance(userStartBalance-donateAmount);
		organizationBank.setBalance(organizationStartBalance+donateAmount);
		
		// print test
		System.out.println("user current balance: " + userBank.getBalance());
		System.out.println("Organization ccurrent balance: " + organizationBank.getBalance());
		
		// persist the changes in database
		contxt.getBean(DataFacade.class).update(userBank);
		contxt.getBean(DataFacade.class).update(organizationBank);
	}
	
	@After
	@Then("^donation amount will be subtracted from user account and added into organization account$")
	public void donation_amount_will_be_subtracted_from_user_account_and_added_into_organization_account() throws Throwable {
		
		// Expected Result to test
		double userBalanceExpected = userStartBalance - donateAmount;
		double organizationBalanceExpected = organizationStartBalance + donateAmount;
		
		// Actual result to test
		double userBalanceActual = contxt.getBean(DataFacade.class).getUser(userId).getBankAccount().getBalance();
		double organizationBalanceActual = contxt.getBean(DataFacade.class).getEvent(eventId).getOrganizationId().getBankId().getBalance();
		
		// precision of double to compare
		double precision = 0;
		
		// Actual comparation of expected and actual data
		assertEquals(userBalanceExpected, userBalanceActual, precision);
		assertEquals(organizationBalanceExpected, organizationBalanceActual, precision);
		
		System.out.println("user expected        : " + userBalanceExpected + "   "
				+ "user actual        : " + userBalanceActual);
		System.out.println("Organization expected: " + organizationBalanceExpected + "  "
				+ "Organization actual: " + organizationBalanceExpected );
	}
}
