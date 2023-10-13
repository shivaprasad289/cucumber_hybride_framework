package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		 publish = true,
        plugin = {
       		  		"pretty",
       		  		"html:target/cucumberReports/htmlReport.html"
           		 },
        glue = {
        		 "stepdefneations",
        		 "hooks"
		       },
        features = "src/test/resource/features"
        )
public class TestRunner{
	
}
