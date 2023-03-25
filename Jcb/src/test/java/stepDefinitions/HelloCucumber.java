package stepDefinitions;
import io.cucumber.java.en.Given;
public class HelloAppium {
    @Given("Hello Cucumber")
    public void HelloCucumber() {
        System.out.println("Hello Cucumber!!");
    }


    @Given("Appium first step")
    public void HelloAppium() {

    }
}
