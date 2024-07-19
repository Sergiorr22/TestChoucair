package com.co.testchoucair.questions;

import com.co.testchoucair.utilities.WebActions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebDriver;

public class Validate implements Question<Boolean> {

    private final Target target;
    private final WebActions webActions;

    public Validate(Target target, WebActions webActions) {
        this.target = target;
        this.webActions = webActions;
    }

    public static Validate elementIsVisible(Target target, WebActions webActions) {
        return new Validate(target, webActions);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        webActions.highlightElement(target.resolveFor(actor));
        return target.resolveFor(actor).isVisible();
    }
}