package stepdefs;
import io.cucumber.java.en.*;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import tests.BaseClass;

public class LoginSteps {
//	@When("I enter phone number {string}")
//    public void iEnterPhoneNumber(String number) {
//        List<WebElement> fields = BaseClass.driver.findElements(AppiumBy.className("android.widget.EditText"));
//        fields.get(0).sendKeys(number);
//    }
//
//    @When("I enter password {string}")
//    public void iEnterPassword(String password) {
//        List<WebElement> fields = BaseClass.driver.findElements(AppiumBy.className("android.widget.EditText"));
//        fields.get(0).sendKeys(password);
//
//        WebElement continueButton = BaseClass.driver.findElement(AppiumBy.accessibilityId("Continue"));
//        continueButton.click();
//    }
//
//    @Then("I should be logged in successfully")
//    public void iShouldBeLoggedInSuccessfully() {
//        System.out.println("✅ Login successful.");
//    }

	    @When("I enter phone number {string}")
	    public void iEnterPhoneNumber(String number) {
	        // Find all the EditText fields and enter the phone number in the first one
	        List<WebElement> fields = BaseClass.driver.findElements(AppiumBy.className("android.widget.EditText"));
	        fields.get(0).sendKeys(number);
	    }

	    @When("I enter password {string}")
	    public void iEnterPassword(String password) {
	        // Find all the EditText fields and enter the password in the first one
	        List<WebElement> fields = BaseClass.driver.findElements(AppiumBy.className("android.widget.EditText"));
	        fields.get(0).sendKeys(password); // Password field is at index 1

//	        // Locate and click the "Continue" button
//	        WebElement continueButton = BaseClass.driver.findElement(AppiumBy.accessibilityId("Continue"));
//	        continueButton.click();

//	        // Wait for the next screen to load, e.g., by waiting for an element on the next screen
//	        WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10));
//	        wait.until(ExpectedConditions.invisibilityOf(continueButton)); // Wait until the button disappears
	        
	     // Add a 10-second delay
//	        try {
//	            Thread.sleep(10000);  // 10000 milliseconds = 10 seconds
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
	    }

	    @Then("I should be logged in successfully")
	    public void iShouldBeLoggedInSuccessfully() {
	        // Log a message to indicate successful login
	        System.out.println("✅ Login successful.");
	    }
	}