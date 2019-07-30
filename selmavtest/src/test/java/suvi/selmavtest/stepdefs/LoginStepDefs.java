package suvi.selmavtest.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import suvi.selmavtest.TestRunner;
import suvi.selmavtest.tests.pages.FindFlightPageObject;
import suvi.selmavtest.tests.pages.LoginPageObject;
import cucumber.api.java.en.Then;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;

public class LoginStepDefs {
	
	private LoginPageObject login = null;
	private FindFlightPageObject findFlight = null;
	
	@Given("^I am on the \"([^\"]*)\" page of \"([^\"]*)\"$")
	public void i_am_on_the_homepage_of_url(String page, String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("method=i_am_on_the_homepage_of_url");
		System.out.println("page=" + page);
		System.out.println("url=" + url);
		getLoginPage().navigateToUrl(url);
		assertTrue(getLoginPage().isTitleContains(page));
	}

	@Then("^I should see \"([^\"]*)\" image in the page$")
	public void i_should_see_image_in_the_page(String imageName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("method=i_should_see_image_in_the_page");
		System.out.println("imageName=" + imageName);
		assertTrue(getLoginPage().checkElement(imageName));
	}

	@Then("^I can see the \"([^\"]*)\" and \"([^\"]*)\" fields$")
	public void i_can_see_the_and_fields(String userNameText, String passwordText) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("method=i_can_see_the_and_fields");
		System.out.println("userNameText=" + userNameText);
		System.out.println("passwordText=" + passwordText);
		assertTrue(getLoginPage().checkElement(userNameText));
		assertTrue(getLoginPage().checkElement(passwordText));
	}

	@When("^I enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void i_enter_username_as_and_password_as(String userName, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("method=i_enter_username_as_and_password_as");
		System.out.println("userName=" + userName);
		System.out.println("password=" + password);
		getLoginPage().enterData("username", userName);
		getLoginPage().enterData("password", password);
	}

	@When("^I click the \"([^\"]*)\" button$")
	public void i_click_the_button(String signOnButtonName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("method=i_click_the_button");
		System.out.println("signOnButtonName=" + signOnButtonName);
		getLoginPage().clickButton(signOnButtonName);
	}

	@Then("^I am signed in and view the \"([^\"]*)\" page$")
	public void i_am_signed_in_and_view_the_page(String signedInPAge) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("method=i_am_signed_in_and_view_the_page");
		System.out.println("signedInPAge=" + signedInPAge);
		assertTrue(getLoginPage().isTitleContains(signedInPAge));
	}

	@Then("^I see the \"([^\"]*)\" form$")
	public void i_see_the_form(String formName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("method=i_see_the_form");
		System.out.println("formName=" + formName);
		assertTrue(getFindFlightPage().checkElement(formName));
	}

	@When("^I fill in username with \"([^\"]*)\"$")
	public void i_fill_in_username_with_username(String username) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("method=i_fill_in_username_with_username");
		System.out.println("username=" + username);
		getLoginPage().enterData("username", username);
	}

	@When("^I fill in password as \"([^\"]*)\"$")
	public void i_fill_in_password_as_password(String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("method=i_fill_in_password_as_password");
		System.out.println("password=" + password);
		getLoginPage().enterData("password", password);
	}

	@Then("^I am redirected to \"([^\"]*)\" page$")
	public void i_am_redirected_to_page(String pageName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("method=i_am_redirected_to_page");
		System.out.println("pageName=" + pageName);
		assertTrue(getLoginPage().isTitleContains(pageName));
	}

	@When("^I fill in username with pqr$")
	public void i_fill_in_username_with_pqr() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		i_fill_in_username_with_username("pqr");
	}

	@When("^I fill in password as pqr$")
	public void i_fill_in_password_as_pqr() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		i_fill_in_password_as_password("pqr");
	}

	@Then("^I am redirected to Sign-on page$")
	public void i_am_redirected_to_Sign_on_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		i_am_redirected_to_page("Sign-on");
	}

	@When("^I fill in username with tutorial$")
	public void i_fill_in_username_with_tutorial() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		i_fill_in_username_with_username("tutorial");
	}

	@When("^I fill in password as tutorial$")
	public void i_fill_in_password_as_tutorial() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		i_fill_in_password_as_password("tutorial");
	}

	@Then("^I am redirected to Find a Flight page$")
	public void i_am_redirected_to_Find_a_Flight_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		i_am_redirected_to_page("Find a Flight");
	}

	private LoginPageObject getLoginPage() {
		
		if (login == null) {
			login = new LoginPageObject(TestRunner.getBrowserSession().getWebDriver());
		}
		return login;
	}

	private FindFlightPageObject getFindFlightPage() {
		if (findFlight == null) {
			findFlight = new FindFlightPageObject(TestRunner.getBrowserSession().getWebDriver());
		}
		return findFlight;
	}
	
}
