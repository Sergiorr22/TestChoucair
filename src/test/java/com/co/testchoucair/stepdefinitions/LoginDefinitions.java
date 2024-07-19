package com.co.testchoucair.stepdefinitions;

import com.co.testchoucair.questions.Validate;
import com.co.testchoucair.tasks.LoginTask;
import com.co.testchoucair.ui.DashboardPage;
import com.co.testchoucair.utilities.WebActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class LoginDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;
    Actor user = Actor.named("User");
    private WebActions webActions;


    @Given("entry into the environment")
    public void theUserIsOnTheLoginPage() {
        user.can(BrowseTheWeb.with(driver));
        user.wasAbleTo(Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }

    @When("the user enters username {string} and password {string}")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        user.attemptsTo(LoginTask.withCredentials(username, password, webActions));
    }

    @Then("Log in correctly")
    public void theUserShouldBeLoggedIn() {
        user.attemptsTo(
                Ensure.that(Validate.elementIsVisible(DashboardPage.LBL_DASHBOARD, webActions)).isTrue()
        );
    }


}

