package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.SkipException;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass {
	public static AndroidDriver driver;

	// Setup before the tests (this acts as the 'Before' hook)
	public static void configureAppium() {
	    try {
	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("Android");
	        options.setDeviceName("TECNO SPARK 20 Pro+");
	        options.setUdid("115333741O006165");
	        options.setAutomationName("UiAutomator2");
	        options.setApp("/Users/waleed/Downloads/3.0.22(3377).apk");
	        options.setPlatformVersion("14");
	        options.setNewCommandTimeout(Duration.ofSeconds(60));

	        URL url = new URL("http://127.0.0.1:4723");
	        driver = new AndroidDriver(url, options);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    } catch (Exception e) {
	        System.out.println("Cause is: " + e.getCause());
	        System.out.println("Message is: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
    @BeforeTest
    public void setup() {
       configureAppium();
    }

 // Test method for app flow (Moved here as a reusable method)
    public static void completeAppOnboardingFlow() {
        // Reusable method to perform the app flow actions
        driver.findElement(AppiumBy.accessibilityId("Continue")).click();
        driver.findElement(AppiumBy.accessibilityId("United Arab Emirates")).click();
        driver.findElement(AppiumBy.accessibilityId("Saudi Arabia")).click();
        driver.findElement(AppiumBy.accessibilityId("Continue")).click();
        driver.findElement(AppiumBy.accessibilityId("Skip")).click();
        driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
    }

    
}
