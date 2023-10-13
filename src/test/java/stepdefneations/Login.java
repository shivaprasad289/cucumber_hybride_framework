package stepdefneations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;
import utils.ElementUtils;

public class Login {
	private WebDriver driver;
	private HomePage hp;
	private LoginPage lp;
	private AccountPage ap;
	private CommonUtils utils;
	private DriverFactory factory;
	private ElementUtils elementUtils;

	public Login() {
		elementUtils = new ElementUtils(driver);
	}

	@Given("User has navigates to login page")
	public void User_has_navigates_to_login_page() {
		factory = new DriverFactory();
		driver = factory.getDriver();
		hp = new HomePage(driver);
		hp.clickOnMyAccount();
		lp = hp.clickOnLoginLink(driver);
	}

	@When("User has enteres valid email address {string}")
	public void user_has_enteres_valid_email_address_into_the_email_field(String validEmail) {
		lp.setEmail(validEmail);
	}

	@When("^User has enteres valid email address (.+) into the email field$")
	public void user_has_enteres_valid_emailaddress_into_the_email_field(String validEmail) {
		lp.setEmail(validEmail);
	}

	@When("User has enteres valid password {string}")
	public void user_has_enteres_valid_password_into_the_passowrd_field(String validPwd) {
		lp.setPwd(validPwd);
	}

	@When("^User has enteres valid password (.+)into the passowrd field$")
	public void user_has_enteres_valid_pwd_into_the_passowrd_field(String validPwd) {
		lp.setPwd(validPwd);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		ap = lp.clickOnLoginBtn(driver);
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		Assert.assertTrue(ap.isAccountPageDisplayed());
	}

	@When("User enters invalid email address into the email field")
	public void user_enters_invalid_email_address_into_the_email_field() {
		utils = new CommonUtils();
		lp.setEmail(utils.generateEmail());
	}

	@When("User enteres invalid passowrd {string} into the password field")
	public void user_enteres_invalid_passowrd_into_the_password_field(String inValidPwd) {
		lp.setPwd(inValidPwd);
	}

	@Then("User should get a proper warning message about credentails mismatch")
	public void user_should_get_a_proper_warning_message_about_credentails_mismatch() {
		Assert.assertTrue(lp.getAlertMsg().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enter email into the email field")
	public void user_dont_enter_email_into_the_email_field() {

	}

	@When("User dont enter passowrd into passowrd field")
	public void user_dont_enter_passowrd_into_passowrd_field() {

	}
}
