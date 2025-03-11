package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="F:\\Eclipse-workspace-RestAssured-April2024\\RestAssured_GooglePlace\\src\\test\\java\\features", 
		glue= {"stepdefinitions"},
		plugin= "json:target/jsonReports/cucumber-report.json",
		dryRun=true//new code for reference to Git
	
)

public class TestRunner_Gitclone {

}
