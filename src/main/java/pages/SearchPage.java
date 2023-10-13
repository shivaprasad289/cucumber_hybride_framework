package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	@FindBy(linkText = "HP LP3065")
	private WebElement prodctName;
	
	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement noProductWarningMsg;
	
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductDisplayed() {
		return prodctName.isDisplayed();
	}
	
	public String getNoProductWarningMsg() {
		return noProductWarningMsg.getText();
	}
}
