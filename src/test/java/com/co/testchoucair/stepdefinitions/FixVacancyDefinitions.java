package com.co.testchoucair.stepdefinitions;

import com.co.testchoucair.tasks.IntoVacancyTask;
import com.co.testchoucair.tasks.LoginTask;
import com.co.testchoucair.utilities.WebActions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class FixVacancyDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;
    Actor user = Actor.named("User");
    private WebActions webActions;

    @Before
    public void setUp(){
        user.can(BrowseTheWeb.with(driver));
    }


    @And("The user enters the vacancies")
    public void theUserEntersTheVacancies() {
        user.attemptsTo(IntoVacancyTask.fixVacancy(webActions));
    }
}
