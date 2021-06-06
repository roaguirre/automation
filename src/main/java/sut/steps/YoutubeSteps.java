package sut.steps;

import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

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

    @Given("I am at '$url'")
    public void givenOnHomePage(String url) throws MalformedURLException {
        try {
            driver.get(url);
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
            driver.wait(10000);
            searchBar.sendKeys(Keys.ENTER);
            driver.wait(10000);
            Assert.assertTrue(driver.getCurrentUrl().contains("results"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I should see '$text' text on the page")
    public void seeTextOnPage(String text) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("[contains(text(),'" + text.trim() + "')]"));
        String containedText = element.getText();
        Assert.assertTrue(text.contains(containedText));
    }

}