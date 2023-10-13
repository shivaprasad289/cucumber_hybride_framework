package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	ElementUtils elemetUtils;
	WebDriver driver;
	@FindBy(id = "input-email")
	private WebElement emailFiled;
	
	@FindBy(id = "input-password")
	private WebElement pwdField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement alertMsg;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		elemetUtils = new ElementUtils(driver);
	}
	public void setEmail(String email) {
		elemetUtils.typeTextIntoTheElement(emailFiled, email, CommonUtils.EXPICIT_WAIT_TIME);
	}
	
	public void setPwd(String pwd) {
		elemetUtils.typeTextIntoTheElement(pwdField, pwd, CommonUtils.EXPICIT_WAIT_TIME);
		pwdField.sendKeys(pwd);
	}
	
	public AccountPage clickOnLoginBtn(WebDriver driver) {
		elemetUtils.click_on_element(loginBtn, CommonUtils.EXPICIT_WAIT_TIME);
		return new AccountPage(driver);
	}
	
	public String alertMsg() {
		return elemetUtils.getTxtFromElelemnt(alertMsg, CommonUtils.EXPICIT_WAIT_TIME);
	}
	public String getAlertMsg() {
		return alertMsg.getText();
	}
}
