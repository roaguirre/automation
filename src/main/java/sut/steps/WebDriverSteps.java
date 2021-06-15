package sut.steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;

import static java.lang.Thread.sleep;

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
    public void givenOnURL(String url) throws MalformedURLException {
        try {
            driver.get(url);
            driver.wait(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I wait for $seconds seconds")
    public void waitFor(int seconds) throws InterruptedException {
        sleep(seconds * 1000);
    }

    @Then("I should see '$text' text on the page")
    public void seeTextOnPage(String text) throws InterruptedException {
        String containedText = driver.findElement(By.xpath("//body")).getText();
        Assert.assertTrue(containedText.contains(text));
    }
}
