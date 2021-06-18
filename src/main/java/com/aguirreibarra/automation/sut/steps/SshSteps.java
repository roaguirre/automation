package com.aguirreibarra.automation.sut.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.io.IOException;

public class SshSteps {

    @Then("I copy $pathToFile into $pathToDestination")
    public void copyOverSsh(String PathToFile, String pathToDestination) throws IOException {
        Runtime.getRuntime().exec("scp " + PathToFile + " username@a:" + pathToDestination);
    }

    @When("I ping $address")
            public void ping(String address){
        try {
            Runtime.getRuntime().exec("ping " + address);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}