package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class AccountPage {
	ElementUtils elementUtils;
	
	@FindBy(linkText = "Account")
	private WebElement accountPageStaticElement;
	
	@FindBy(xpath = "//h1[contains(text(),'Created!')]")
	private WebElement successMsg;
	
	public AccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	public boolean isAccountPageDisplayed() {
		return accountPageStaticElement.isDisplayed();
	}
	
	public String getSuccessMsg() {
		return elementUtils.getTxtFromElelemnt(successMsg, CommonUtils.EXPICIT_WAIT_TIME);
	}
}
