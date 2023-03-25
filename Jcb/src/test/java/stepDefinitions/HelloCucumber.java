package stepDefinitions;

import io.cucumber.java.en.Given;

public class HelloCucumber {
    @Given("Hello Cucumber")
    public void HelloCucumber() {
        System.out.println("Hello Cucumber!!");
    }
}
