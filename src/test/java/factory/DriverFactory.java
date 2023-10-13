package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.CommonUtils;

public class DriverFactory {
	static WebDriver driver;

	public WebDriver initilizeBrowser(String browserName) {
		if (browserName.equals("chrome"))
			driver = new ChromeDriver();
		else if (browserName.equals("edge"))
			driver = new EdgeDriver();
		else if (browserName.equals("firefox"))
			driver = new FirefoxDriver();
		else if (browserName.equals("safari"))
			driver = new SafariDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		
		return driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
