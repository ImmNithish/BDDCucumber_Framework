package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions
		(
				
		features = "./Features",
		glue="stepDefinition",
		monochrome = true,
		dryRun = false,
		//tags= "@regression",
		//tags="@complete",
		plugin = {"pretty","html:target/Report.html"}
		
		)

public class TestRunner {

}
