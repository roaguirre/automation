package sut.steps;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSteps {
    ChromeDriver driver;

    @BeforeScenario
    public void startBrowserBeforeScenario(){
        this.driver = new ChromeDriver(new ChromeOptions());
    }

    @AfterScenario
    public void shutDownBrowserBeforeScenario(){
        driver.quit();
    }
}
