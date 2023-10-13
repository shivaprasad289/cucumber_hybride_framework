package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	private WebDriver driver;
	private ElementUtils elementUtils;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountdropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginLink;

	@FindBy(linkText = "Register")
	private WebElement registerLink;

	@FindBy(name = "search")
	private WebElement searchTxtBox;

	@FindBy(xpath = "//button[contains(@class,'btn btn-default')]")
	private WebElement searchBtn;

	public void enterTxtIntoSearchTxtBox(String productName) {
		elementUtils.typeTextIntoTheElement(searchTxtBox, productName, CommonUtils.EXPICIT_WAIT_TIME);
	}

	public void clickOnMyAccount() {
		elementUtils.click_on_element(myAccountdropMenu, CommonUtils.EXPICIT_WAIT_TIME);
	}

	public LoginPage clickOnLoginLink(WebDriver driver) {
		elementUtils.click_on_element(loginLink, CommonUtils.EXPICIT_WAIT_TIME);
		return new LoginPage(driver);
	}

	public RegisterPage clickOnRegisterLink(WebDriver driver) {
		elementUtils.click_on_element(registerLink, CommonUtils.EXPICIT_WAIT_TIME);
		return new RegisterPage(driver);
	}

	public SearchPage clickOnSearchBtn(WebDriver driver) {
		elementUtils.click_on_element(searchBtn, CommonUtils.EXPICIT_WAIT_TIME);
		return new SearchPage(driver);
	}
}
