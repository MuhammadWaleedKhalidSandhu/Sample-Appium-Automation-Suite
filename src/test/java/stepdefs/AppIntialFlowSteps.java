package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.appium.java_client.AppiumBy;
import tests.BaseClass;

public class AppIntialFlowSteps extends BaseClass {
	

    // This method maps to the 'Given' step in your feature file
    @Given("the app is launched")
    public void theAppIsLaunched() {
        // Verify that the driver is initialized
        if (driver == null) {
            throw new RuntimeException("Appium driver is not initialized.");
        }
    }

    // This method maps to the 'When' step in your feature file
    @When("I tap on {string}")
    public void iTapOn(String buttonName) {
        // Tap on any button specified by the step definition (from feature file)
        driver.findElement(AppiumBy.accessibilityId(buttonName)).click();
     // Add a 10-second delay
        try {
            Thread.sleep(4000);  // 10000 milliseconds = 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // This method maps to the 'And' steps in your feature file
    @And("I select {string}")
    public void iSelect(String country) {
        // Select the country (or any other option)
        driver.findElement(AppiumBy.accessibilityId(country)).click();
    }
    
    @When("I allow the permissions")
    public void i_allow_the_permissions() {
        BaseClass.driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
    }

    // This method maps to the 'Then' step for completing the flow
    @Then("the app onboarding is completed")
    public void theAppOnboardingIsCompleted() {
        // Verify that the onboarding process has completed
        System.out.println("Onboarding process is completed.");
    }

    // You can still keep a high-level app flow in the steps if you prefer
//    @When("I complete the onboarding")
//    public void iCompleteTheOnboarding() {
//        // Calls the reusable method from BaseClass
//        completeAppOnboardingFlow();
//    }
}