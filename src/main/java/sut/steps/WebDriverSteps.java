package sut.steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverSteps {
    ChromeDriver driver;

    @BeforeScenario
    public static void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeScenario
    public void startBrowserBeforeScenario(){
        this.driver = new ChromeDriver(new ChromeOptions());
    }

    @AfterScenario
    public void shutDownBrowserAfterScenario(){
        driver.quit();
    }

    @Given("I am at '$url'")
    @When("I am at '$url'")
    public void whenOnURL(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I find '$text' text on the page")
    public void isTextOnPage(String text) {
        String containedText = getWithTimeout(By.xpath("//body"),5000).getText();
        Assert.assertTrue(containedText.contains(text));
    }

    public WebElement getWithTimeout(By locator, int timeOutInMillis){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeOutInMillis));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
}
