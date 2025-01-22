package org.cucumber.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeScenario() {
        System.out.println("");
        System.out.println("TEST SCENARIO SI STARTING ------------------------->");
        System.out.println("");
    }

    @After
    public void afterScenario() {
        System.out.println("");
        System.out.println("-------------------------> TEST SCENARIO ENDED");
        System.out.println("");
    }
}
