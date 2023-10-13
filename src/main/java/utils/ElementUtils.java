package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitForElement(WebElement element, int durationInSec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSec));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement Wait_for_visibility_of_element(WebElement element, WebDriver driver, int durationInSec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSec));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void click_on_element(WebElement element, int durationInSec) {
		WebElement web_element = waitForElement(element, durationInSec);
		web_element.click();
	}

	public void typeTextIntoTheElement(WebElement element, String txtToBeTyped, int durationInSec) {
		WebElement web_element = waitForElement(element, durationInSec);
		web_element.click();
		web_element.clear();
		web_element.sendKeys(txtToBeTyped);
	}

	public void selectOptionInDropDown(WebElement element, String dropdownTxt, int durationInsec) {
		WebElement web_element = waitForElement(element, durationInsec);
		Select s = new Select(web_element);
		s.selectByVisibleText(dropdownTxt);
	}

	public void acceptAlert(Duration durationInsec) {
		Alert alert = waitForAlert(durationInsec);
		alert.accept();
	}

	public void dismissAlert(Duration durationInsec) {
		Alert alert = waitForAlert(durationInsec);
		alert.dismiss();
	}

	public Alert waitForAlert(Duration durationInsec) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, durationInsec);
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alert;
	}

	public void mouse_hover_click(WebElement element, int durationInsec) {
		WebElement web_element = Wait_for_visibility_of_element(element, driver, durationInsec);
		Actions a = new Actions(driver);
		a.moveToElement(web_element).click().build().perform();
	}

	public void javaScriptClick(WebElement element, int durationInSec) {
		WebElement web_element = Wait_for_visibility_of_element(element, driver, durationInSec);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", web_element);
	}

	public void javascriptType(WebElement element, String txtTobeTyped, int durationInsec) {
		WebElement web_element = Wait_for_visibility_of_element(element, driver, durationInsec);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + txtTobeTyped + "'", web_element);
	}
	
	public String getTxtFromElelemnt(WebElement element,int durationInSec) {
		WebElement web_element = Wait_for_visibility_of_element(element, driver, durationInSec);
		return web_element.getText();
	}
}
