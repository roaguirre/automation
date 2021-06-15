package sut.steps;

import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static java.lang.Thread.sleep;

public class YoutubeSteps extends WebDriverSteps {

    @Given("I am on YOUTUBE_HOME page")
    public void givenOnHomePage() throws MalformedURLException {
        try {
            driver.get("https://youtube.com/");
            driver.wait(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I search for '$keyword'")
    public void search(String keyword) {
        try {
            WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));
            searchBar.sendKeys(keyword);
            sleep(10000);
            searchBar.sendKeys(Keys.ENTER);
            sleep(10000);
            Assert.assertTrue(driver.getCurrentUrl().contains("results"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}