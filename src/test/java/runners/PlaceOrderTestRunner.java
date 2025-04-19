package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/place_order.feature", // path to your .feature file
    glue = {"stepdefs"},                                // your step definitions package
    tags = "@order",                                    // run only tagged scenarios
    plugin = {"pretty", "html:target/placeorder-report.html"},
    monochrome = true
)
public class PlaceOrderTestRunner extends AbstractTestNGCucumberTests {
}
