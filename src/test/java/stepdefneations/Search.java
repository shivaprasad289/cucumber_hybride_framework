package stepdefneations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;

public class Search {
	private WebDriver driver;
	private HomePage hp;
	private SearchPage sp;
	private DriverFactory factory;

	@Given("User opens the application")
	public void user_opens_the_application() {
		factory = new DriverFactory();
		driver = factory.getDriver();
		hp = new HomePage(driver);
	}

	@When("User enters valid product {string} into search textfield")
	public void user_enters_valid_product_into_search_textfield(String validProduct) {
		hp.enterTxtIntoSearchTxtBox(validProduct);
	}

	@When("User clicks on search button")
	public void clicks_on_search_button() {
		sp = hp.clickOnSearchBtn(driver);
	}

	@Then("User should get valid product in search field")
	public void user_should_get_valid_product_in_search_field() {
		Assert.assertTrue(sp.isProductDisplayed());
	}

	@When("User enters invalid product {string} into search textfield")
	public void user_enters_invalid_product_into_search_textfield(String invalidProduct) {
		hp.enterTxtIntoSearchTxtBox(invalidProduct);
	}

	@Then("User should get a no product matching message")
	public void user_should_get_a_no_product_matching_message() {
		Assert.assertEquals("There is no product that matches the search criteria.", sp.getNoProductWarningMsg());
	}

	@When("User donot enter any product name into search textfield")
	public void user_donot_enter_any_product_name_into_search_textfield() {

	}
}
