package stepdefneations;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	private WebDriver driver;
	private HomePage hp;
	private RegisterPage rp;
	private AccountPage ap;
	private CommonUtils utils;
	private DriverFactory factory;

	@Given("User navigates to register account page")
	public void user_navigates_to_register_account_page() {
		factory = new DriverFactory();
		driver = factory.getDriver();
		hp = new HomePage(driver);
		hp.clickOnMyAccount();
		rp = hp.clickOnRegisterLink(driver);
	}

	@When("User enters the below fields")
	public void user_enters_the_below_fields(DataTable dt) {
		Map<String, String> data = dt.asMap(String.class, String.class);
		utils = new CommonUtils();
		rp.enterRequiredDetails(data.get("FirstName"), data.get("LastName"),utils.generateEmail(),
				data.get("Telephone"), data.get("Password"));
	}

	@When("User enters the details into the below details with duplicate email")
	public void User_enters_the_details_into_the_below_details_with_duplicate_email(DataTable dt) {
		Map<String, String> data = dt.asMap(String.class, String.class);
		rp.enterRequiredDetails(data.get("FirstName"), data.get("LastName"), data.get("Email"), data.get("Telephone"),
				data.get("Password"));
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		rp.selectAgreeCheckBox();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		ap = rp.clickOnContinueBtn(driver);
	}

	@Then("User account should get created")
	public void user_account_should_get_created() {
		Assert.assertEquals(ap.getSuccessMsg(), "Your Account Has Been Created!");
	}

	@When("User selects Yes for newsletter")
	public void user_selects_yes_for_newsletter() {
		rp.selectSubscribeRadioBtn();
	}

	@Then("User should get a proper warning for duplicate email")
	public void user_should_get_a_proper_warning_for_duplicate_email() {
		Assert.assertTrue(rp.getAlretMsg().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User donot enters any details into fields")
	public void user_donot_enters_any_details_into_fields() {
		// Implementation not required
	}

	@Then("User should get proper warning message for every mandatory fields")
	public void user_should_get_proper_warning_message_for_every_mandatory_fields() {
		Assert.assertTrue(rp.getPrivacyPolicyWarningMsg().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", rp.getFirstNameTxtFieldWarningMsg());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", rp.getLastNameTxtFieldWarningMsg());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", rp.getEmailTxtFieldWarningMsg());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", rp.getTelephoneTxtFieldWarningMsg());
		Assert.assertEquals("Password must be between 4 and 20 characters!", rp.getPwdTxtFieldWarningMsg());
	}
}
