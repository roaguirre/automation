package com.aguirreibarra.automation.sut.steps;

import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class YoutubeSteps extends WebDriverSteps {

    @When("I search for '$keyword'")
    public void search(String keyword) {
        try {
            WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));
            searchBar.sendKeys(keyword);
            sleep(1000);
            searchBar.sendKeys(Keys.ENTER);
            sleep(1000);
            Assert.assertTrue(driver.getCurrentUrl().contains("results"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}