package com.teknasyon.automation.cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com/teknasyon/automation/stepdefinitions"},
        features = "src/test/resources/features",
        plugin = {"pretty", "summary"})
public class RunCucumberTest {
}
