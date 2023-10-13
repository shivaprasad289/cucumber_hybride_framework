package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	private WebDriver driver;
	private DriverFactory factory;
	@Before
	public void setUp() {
		Properties p = new ConfigReader().inializeProperties();
		factory = new DriverFactory();
		driver = factory.initilizeBrowser(p.getProperty("browser"));
		driver.get(p.getProperty("url"));
	}
	
	@After
	public void tearDown(Scenario scenario) {
		String scenarioName = scenario.getName().replace(" ","_");
		byte[] sceenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sceenShot, "image/png", scenarioName);
		driver.quit();
	}
}
