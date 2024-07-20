package com.co.testchoucair.utilities;


import lombok.Getter;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.time.Duration;

public class WebActions extends PageObject {

    @Getter
    private WebDriver driver;
    private Logger logger = LoggerFactory.getLogger(WebActions.class);

    public WebActions(WebDriver driver) {
        this.driver = driver;
    }

    public void exceptionWebActions(Exception e) {
        String[] strExcepcion = e.getClass().getCanonicalName().replace(".", "-").split("-");
        ExceptionsProyecto.validaExcepcion(strExcepcion[strExcepcion.length - 1]);
    }

    public Duration getSerenityTime() {
        return getImplicitWaitTimeout();
    }

    public void highlightElement(WebElement element) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px dashed red'", element);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.background='#cc8f94'", element);
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo highlightElement " + e);
            exceptionWebActions(e);
        }
    }

    public void writeText(WebElementFacade element, String strText) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), getSerenityTime());
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.type(strText);
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo writeText " + e);
            exceptionWebActions(e);
        }
    }

    public Interaction highlightElement(Target target) {
        return Tasks.instrumented(HighlightElement.class, target);
    }

    public Interaction writeText(Target target, String text) {
        return Tasks.instrumented(WriteText.class, target, text);
    }

    public Interaction clickButton(Target target) {
        return Tasks.instrumented(ClickButton.class, target);
    }

    public Interaction scrollTo(Target target) {
        return Tasks.instrumented(ScrollTo.class, target);
    }

    public Interaction waitForElement(Target target) {
        return Tasks.instrumented(WaitForElement.class, target);
    }




    public static class HighlightElement implements Interaction {
        private final Target target;

        public HighlightElement(Target target) {
            this.target = target;
        }

        @Override
        public <T extends Actor> void performAs(T actor) {
            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            WebElement element = target.resolveFor(actor);
            WebActions webActions = new WebActions(driver);
            webActions.highlightElement(element);
        }
    }

    public static class WriteText implements Interaction {
        private final Target target;
        private final String text;

        public WriteText(Target target, String text) {
            this.target = target;
            this.text = text;
        }

        @Override
        public <T extends Actor> void performAs(T actor) {
            WebElementFacade element = target.resolveFor(actor);
            WebActions webActions = new WebActions(BrowseTheWeb.as(actor).getDriver());
            webActions.writeText(element, text);
        }
    }

    public static class ClickButton implements Interaction {
        private final Target target;

        public ClickButton(Target target) {
            this.target = target;
        }

        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(net.serenitybdd.screenplay.actions.Click.on(target));
        }
    }

    public static class ScrollTo implements Interaction {
        private final Target target;

        public ScrollTo(Target target) {
            this.target = target;
        }

        @Override
        public <T extends Actor> void performAs(T actor) {
            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            WebElement element = target.resolveFor(actor);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }
    }

    public static class WaitForElement implements Interaction {
        private final Target target;


        public WaitForElement(Target target) {
            this.target = target;

        }

        @Override
        public <T extends Actor> void performAs(T actor) {
            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(target.resolveFor(actor)));
        }
    }



}
