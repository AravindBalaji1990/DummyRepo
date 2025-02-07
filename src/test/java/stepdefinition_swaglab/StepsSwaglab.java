package stepdefinition_swaglab;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class StepsSwaglab {
    AndroidDriver driver;
    Scenario scenario;

    @Before
    public void setup(Scenario scenario) {
        System.out.println("before");
        this.scenario = scenario;
    }
    @Given("User open Android device")
    public void user_open_android_device() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
        options.setAppWaitForLaunch(true);

        // calling the andorid driver to run the app
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);
        scenario.log("this is the first step");
    }

    @When("User enter the user name")
    public void user_enter_the_user_name() {
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys("standard_user");
        scenario.log("Entering the username");

    }

    @When("User enter the password")
    public void user_entet_the_password() {
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys("secret_sauce");
        scenario.log("Entering the password");


    }

    @Then("User clicks on the login")
    public void user_clicks_on_the_login() throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOGIN\"]")).click();
        scenario.log("clicking the login");
    }

    @Then("User is able to see the dashboard")
    public void user_is_able_to_see_the_dashboard() throws InterruptedException {


//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        FluentWait<WebDriver> fluentwait = new FluentWait<>(driver);
        fluentwait.withTimeout(Duration.ofSeconds(60))//max time
                .pollingEvery(Duration.ofMillis(5000))// for every 5000milli second in the 60 second it will ignore the exception if the elemnt is not there

                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        fluentwait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]")));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]"))));
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]")).isDisplayed());
        scenario.log("Validating the dasboard : " + driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]")).isDisplayed());

        Thread.sleep(3000);
        driver.quit();
    }
}
