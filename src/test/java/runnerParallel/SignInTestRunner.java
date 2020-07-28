package runnerParallel;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber-html-report", "json:target/cucumber.json",
        "pretty:target/cucumber-pretty.txt", "junit:target/cucumber-results.xml",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, features = "src/test/resources/featureParallel/SignIn.feature", glue = {
        "stepDefinitionParallel"})

public class SignInTestRunner {

}

