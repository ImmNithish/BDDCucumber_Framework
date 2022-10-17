package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions
		(
				
		features = "./Features/Login.feature",
		glue="stepDefinition",
		monochrome = true,
		dryRun = false,
		plugin = {"pretty","html:target/Report.html"}
		
		)

public class TestRunner {

}
