package stepdefs;

import org.testng.annotations.AfterTest;
import io.cucumber.java.Before;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.SkipException;
import tests.BaseClass;

public class Hooks {

    @Before
    public void setUp() throws Exception {
        if (BaseClass.driver == null) {
            BaseClass base = new BaseClass();
            base.configureAppium(); // Make sure this method sets up the driver
        }
    }
    
 // Teardown after tests (this acts as the 'After' hook)
    @AfterTest
    public void teardown() {
        if (BaseClass.driver != null) {
            BaseClass.driver.quit(); // Close the Appium session
        }
    }
}