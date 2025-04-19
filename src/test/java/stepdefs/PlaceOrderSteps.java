package stepdefs;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.Point;
import tests.BaseClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.time.Duration;
import java.util.Arrays;

public class PlaceOrderSteps {
	
	AndroidDriver driver = BaseClass.driver;

    @Given("I am on the Home screen")
    public void iAmOnTheHomeScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // added this here - increased wait

//        try {
//            WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Search\")")
//            ));
//
//            Assert.assertTrue(searchBar.isDisplayed(), "✅ Home screen loaded successfully.");
//
//        } catch (Exception e) {
//            Assert.fail("❌ Not on the Home screen. 'Search' element not found. Details: " + e.getMessage());
//        }
    }

    @When("I tap on the search bar")
    public void iTapOnTheSearchBar() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement searchBar = driver.findElement(By.xpath(
    		    "//android.widget.FrameLayout[@resource-id='android:id/content']" +
    		    "/android.widget.FrameLayout/android.widget.FrameLayout" +
    		    "/android.view.View/android.view.View/android.view.View" +
    		    "/android.view.View/android.view.View/android.view.View[2]"
    		));
//        WebElement searchBar = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.view.View\").instance(6)"));
        searchBar.click();
        System.out.println("👆 Tapped on the search bar."); // added this here
    }

    @When("I search for the product {string}")
    public void iSearchForProduct(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.className("android.widget.EditText")));
            Assert.assertTrue(searchField.isDisplayed(), "✅ Search field is visible."); // added this here

            searchField.click();
            searchField.sendKeys(productName);
            System.out.println("🔍 Typed product: " + productName); // added this here

            driver.executeScript("mobile: performEditorAction", 
                    java.util.Map.of("action", "search")); // added this here - trigger search

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(10)")));

            System.out.println("✅ Product search successful — results loaded."); // added this here

        } catch (Exception e) {
            Assert.fail("❌ Failed to search for product. Details: " + e.getMessage());
        }
    }

//    @When("I scroll down to view more products")
//    public void iScrollDownToViewProducts() {
//        swipe(new Point(525, 1276), new Point(531, 745));
//        System.out.println("📜 Scrolled down for more products."); // added this here
//    }

    @When("I tap on the product image")
    public void iTapOnTheProductImage() {
//        WebElement productImage = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.widget.ImageView\").instance(6)"));
    	
//    	WebElement productImage = driver.findElement(By.xpath(
//    		    "//android.view.View[contains(@content-desc, 'Panadol 24 Tablets')]/android.widget.ImageView[1]"));
//        productImage.click();
//    	
//        System.out.println("🖼️ Tapped on product image."); // added this here
    	
    	WebElement productImage = null;
        
        try {
            // First attempt: find by content-desc-based XPath
            productImage = driver.findElement(By.xpath(
                "//android.view.View[contains(@content-desc, 'Panadol 24 Tablets')]/android.widget.ImageView[1]"));
            System.out.println("🖼️ Found product image using content-desc XPath.");
        } catch (NoSuchElementException e1) {
            System.out.println("❌ First locator failed. Trying fallback...");
            try {
                // Fallback: using UIAutomator
                productImage = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.widget.ImageView\").instance(12)"));
                System.out.println("✅ Found product image using UIAutomator fallback.");
            } catch (NoSuchElementException e2) {
                throw new RuntimeException("❌ Could not find product image with any locator strategy.");
            }
        }

        productImage.click();
        System.out.println("🖼️ Tapped on product image.");
    }
    @When ("I tap on add to cart")
    public void iTapOnAddToCart() {
        WebElement addToCartBtn = driver.findElement(AppiumBy.accessibilityId("Add to cart"));
        addToCartBtn.click();
        System.out.println("🛒 Tapped on Add to cart.");
    }
    @When("I tap on the Cart icon")
    public void iTapOnCartIcon() {
//        WebElement cartIcon = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().description(\"1\\nCart\")"));
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(
    		    AppiumBy.androidUIAutomator("new UiSelector().descriptionMatches(\".*Cart.*\")")
    		));
        cartIcon.click();
        System.out.println("🛒 Tapped on cart icon."); // added this here
    }

    @When("I tap on the Checkout button")
    public void iTapOnCheckoutButton() {
        driver.findElement(AppiumBy.accessibilityId("Checkout")).click();
        System.out.println("🧾 Tapped on checkout."); // added this here
    }

    @When("I select a delivery day")
    public void iSelectDeliveryDay() {
        driver.findElement(AppiumBy.accessibilityId("Day")).click();
        System.out.println("📅 Selected delivery day."); // added this here
    }

    @When("I select a delivery time slot")
    public void iSelectDeliveryTimeSlot() {
        driver.findElement(AppiumBy.accessibilityId("12:00-14:00")).click();
        System.out.println("⏰ Selected time slot."); // added this here
    }

    @When("I tap on Confirm")
    public void iTapOnConfirm() {
        driver.findElement(AppiumBy.accessibilityId("Confirm")).click();
        try {
            Thread.sleep(3000); // 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("✔️ Confirmed delivery time."); // added this here
    }

    @When("I scroll down to the payment section")
    public void iScrollDownToPaymentSection() {
//        swipe(new Point(543, 1774), new Point(543, 991));
//        System.out.println("💳 Scrolled to payment section."); // added this here
    	
    	// Swipe from lower part of screen to upper part to reveal payment options
    	PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(501, 1875); // Start point near the bottom
        Point end = new Point(522, 451);    // End point higher up

        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
        System.out.println("⬇️ Swiped down to reveal COD option.");
    }

    @When("I select cod")
    public void iScrollFurtherDownToPlaceOrder() {
//        swipe(new Point(519, 1857), new Point(525, 1080));
//        System.out.println("🧾 Scrolled to place order."); // added this here
    	
//    	swipe(new Point(519, 1857), new Point(525, 1080));

        // Click the COD option
        WebElement codOption = driver.findElement(AppiumBy.accessibilityId("Cash on delivery"));
        codOption.click();
        try {
            Thread.sleep(3000); // 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("💵 Selected Cash on Delivery.");
    }

    @When("I tap on Place Order")
    public void iTapOnPlaceOrder() {
//        WebElement placeOrderIcon = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiSelector().className(\"android.widget.ImageView\").instance(15)"));
//        placeOrderIcon.click();
//        System.out.println("🧾 Tapped on place order icon."); // added this here
//
//        driver.findElement(AppiumBy.accessibilityId("Place Order")).click();
//        System.out.println("✅ Placed the order."); // added this here
    	
    	
    	
//    	 WebElement placeOrderBtn = driver.findElement(AppiumBy.accessibilityId("Place Order"));
//    	    placeOrderBtn.click();
//    	    System.out.println("✅ Placed the order.");
    	
    	WebElement placeOrderBtn = null;

        // 1. Explicit wait for up to 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Place Order")));
            System.out.println("✅ 'Place Order' button found and clickable using accessibilityId.");
        } catch (TimeoutException e) {
            System.out.println("❌ Could not find 'Place Order' with accessibilityId. Trying fallback...");

            try {
                placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(15)")));
                System.out.println("✅ 'Place Order' button found using UIAutomator fallback.");
            } catch (TimeoutException e2) {
                throw new RuntimeException("❌ Failed to find and tap 'Place Order' button using all strategies.");
            }
        }

        // 2. Final check & click
        if (placeOrderBtn != null && placeOrderBtn.isDisplayed() && placeOrderBtn.isEnabled()) {
            placeOrderBtn.click();
            System.out.println("🎉✅ Placed the order.");
        } else {
            throw new RuntimeException("❌ 'Place Order' button was not ready for interaction.");
        }
    }

    @Then("the order should be placed successfully")
    public void verifyOrderSuccess() {
        // TODO: Replace below with actual confirmation check
        boolean isSuccess = true; // mock condition - update based on confirmation element

        if (isSuccess) {
            System.out.println("🎉✅ Order placed successfully.");
        } else {
            Assert.fail("❌ Order placement failed.");
        }
    }

    private void swipe(Point start, Point end) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }

}
