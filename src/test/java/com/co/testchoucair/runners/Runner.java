package com.co.testchoucair.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/co/testchoucair/stepdefinitions",
        tags = "@candidates",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}

