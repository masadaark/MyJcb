package Runners;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="Features"
        ,glue = "stepDefinitions"
        ,dryRun = false
        ,monochrome = true
        ,tags = "@regression" //tags can add and,or,not
        //command for tag mvn test -D"cucumber.filter.tags=@Smoke"
        ,plugin = {"json:target/cucumber-reports/cucumber.json"}
)
public class Regression  {

}