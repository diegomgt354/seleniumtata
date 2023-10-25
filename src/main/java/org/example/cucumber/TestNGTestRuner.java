package org.example.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = "src/main/java/org/example/cucumber",
        glue="org.example.seleniumTest.steps",
        monochrome = true,
        plugin = {"pretty","html:reports/cucumber.html"},
        tags = "@Login")
public class TestNGTestRuner extends AbstractTestNGCucumberTests {

}
