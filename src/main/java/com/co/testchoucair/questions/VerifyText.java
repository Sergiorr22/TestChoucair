package com.co.testchoucair.questions;

import com.co.testchoucair.utilities.WebActions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerifyText implements Question<Boolean> {

    private final Target target;
    private final String expectedText;
    private final WebActions webActions;


    public VerifyText(Target target, String expectedText, WebActions webActions){
        this.target = target;
        this.expectedText = expectedText;
        this.webActions = webActions;
    }

    public static VerifyText forTarget(Target target, String expectedText, WebActions webActions) {
        return new VerifyText(target, expectedText, webActions);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(target.resolveFor(actor)));
        webActions.highlightElement(target.resolveFor(actor));
        return target.resolveFor(actor).getText().equals(expectedText);
    }



}
