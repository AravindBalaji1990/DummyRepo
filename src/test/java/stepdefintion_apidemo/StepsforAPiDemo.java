package stepdefintion_apidemo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class StepsforAPiDemo {
    AndroidDriver driver;

    @Given("User launched the app in android")
    public void user_launched_the_app_in_android() throws InterruptedException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);

        // calling the andorid driver to run the app
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);
    }
    @When("the User lands on the dashboard")
    public void the_user_lands_on_the_dashboard() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"android:id/action_bar\"]")).isDisplayed());

    }
    @Then("the user verifies the Graphics button")
    public void the_user_verifies_the_graphics_button() {
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Graphics\"]")).isDisplayed());

    }
    @Then("User close the app")
    public void user_close_the_app() {
       driver.quit();
    }
}
