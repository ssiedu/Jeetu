package demo.test;

import googleLocator.GoogleSignupLocator;
import common.Driverutil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;

public class GoogleSignupSteps {
	
	@Given("^user should be on google home page$")
	public void user_should_be_on_google_home_page() throws Throwable {
	   String s = Driverutil.driver.getCurrentUrl();
	   assertTrue(s.contains("https://accounts.google.com/signin"));
	    System.out.println("User is on sign in page");
	   
	}

	@When("^user enter email id as \"(.*?)\"$")
	public void user_enter_email_id_as(String arg1) throws Throwable {
	    Driverutil.Entertext(arg1, GoogleSignupLocator.emailid);
	    System.out.println("User has enter email as = " +arg1);
	}

	@When("^click on the first next button$")
	public void click_on_the_next_button() throws Throwable {
	    Driverutil.ClickOnTheElement(GoogleSignupLocator.next1);
	    System.out.println("User click on the next button");
	}

	@Then("^verify it is showing the next page with password field$")
	public void verify_it_is_showing_the_next_page_with_password_field() throws Throwable {
	    Driverutil.waitElementDisplayedImplicitlyForSeconds(GoogleSignupLocator.password, 30);
	}

	@When("^usre enter password as \"(.*?)\"$")
	public void usre_enter_password_as(String arg1) throws Throwable {
	    Driverutil.Entertext(arg1, GoogleSignupLocator.password);
	    System.out.println("User enter password as = "+arg1);
	}

	@When("^click on the second next button$")
	public void click_on_the_second_next_button() throws Throwable {
	    Driverutil.ClickOnTheElement(GoogleSignupLocator.next2);
	    System.out.println("User click on the next button");
	}
	
	@Then("^verify that user is on home page$")
	public void verify_that_user_is_on_home_page() throws Throwable {
		Driverutil.waitElementDisplayedImplicitlyForSeconds(GoogleSignupLocator.compose, 30);
	}


}
