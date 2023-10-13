package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	ElementUtils elementUtils;

	@FindBy(id = "input-firstname")
	private WebElement firstNameTxt;

	@FindBy(id = "input-lastname")
	private WebElement lastNameTxt;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement pwdField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPwd;

	@FindBy(name = "agree")
	private WebElement agreeCheckBox;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueBtn;

	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement subscribeRadioBtn;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement alertMsg;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarningMsg;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameTxtFieldWarningMsg;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameTxtFieldWarningMsg;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailFieldWarningMsg;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneTxtFieldWarningMsg;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement pwdTxtFieldWarningMsg;

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	public void enterRequiredDetails(String firstName, String lastName, String email, String number, String pwd) {
		firstNameTxt.sendKeys(firstName);
		lastNameTxt.sendKeys(lastName);
		emailField.sendKeys(email);
		telephoneField.sendKeys(number);
		pwdField.sendKeys(pwd);
		confirmPwd.sendKeys(pwd);
	}

	public void selectAgreeCheckBox() {
		elementUtils.click_on_element(agreeCheckBox, CommonUtils.EXPICIT_WAIT_TIME);
	}

	public AccountPage clickOnContinueBtn(WebDriver driver) {
		elementUtils.click_on_element(continueBtn, CommonUtils.EXPICIT_WAIT_TIME);
		return new AccountPage(driver);
	}

	public void selectSubscribeRadioBtn() {
		elementUtils.click_on_element(subscribeRadioBtn, CommonUtils.EXPICIT_WAIT_TIME);
	}

	public String getAlretMsg() {
		return elementUtils.getTxtFromElelemnt(alertMsg, CommonUtils.EXPICIT_WAIT_TIME);
	}

	public String getPrivacyPolicyWarningMsg() {
		return elementUtils.getTxtFromElelemnt(privacyPolicyWarningMsg, CommonUtils.EXPICIT_WAIT_TIME);
	}

	public String getFirstNameTxtFieldWarningMsg() {
		return elementUtils.getTxtFromElelemnt(firstNameTxtFieldWarningMsg, CommonUtils.EXPICIT_WAIT_TIME);
	}

	public String getLastNameTxtFieldWarningMsg() {
		return elementUtils.getTxtFromElelemnt(lastNameTxtFieldWarningMsg, CommonUtils.EXPICIT_WAIT_TIME);
	}

	public String getEmailTxtFieldWarningMsg() {
		return elementUtils.getTxtFromElelemnt(emailFieldWarningMsg, CommonUtils.EXPICIT_WAIT_TIME);
	}

	public String getTelephoneTxtFieldWarningMsg() {
		return elementUtils.getTxtFromElelemnt(telephoneTxtFieldWarningMsg, CommonUtils.EXPICIT_WAIT_TIME);
	}

	public String getPwdTxtFieldWarningMsg() {
		return elementUtils.getTxtFromElelemnt(pwdTxtFieldWarningMsg, CommonUtils.EXPICIT_WAIT_TIME);
	}
}