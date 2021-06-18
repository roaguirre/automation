package sut.steps;

import org.jbehave.core.annotations.When;

import static java.lang.Thread.sleep;

public class JavaSteps {
    @When("I wait for $seconds seconds")
    public void waitFor(int seconds) throws InterruptedException {
        sleep(seconds * 1000);
    }
}
