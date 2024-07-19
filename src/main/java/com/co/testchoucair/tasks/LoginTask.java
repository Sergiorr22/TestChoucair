package com.co.testchoucair.tasks;

import com.co.testchoucair.ui.LoginPage;
import com.co.testchoucair.utilities.WebActions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class LoginTask implements Task {

    private final String username;
    private final String password;
    private final WebActions webActions;

    public LoginTask(String username, String password, WebActions webActions) {
        this.username = username;
        this.password = password;
        this.webActions = webActions;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                webActions.highlightElement(LoginPage.LBL_USERNAME),
                webActions.writeText(LoginPage.LBL_USERNAME, username),
                webActions.highlightElement(LoginPage.LBL_PASSWORD),
                webActions.writeText(LoginPage.LBL_PASSWORD, password),
                webActions.highlightElement(LoginPage.BTN_LOGIN),
                webActions.clickButton(LoginPage.BTN_LOGIN)
        );
    }

    public static LoginTask withCredentials(String username, String password, WebActions webActions) {
        return Tasks.instrumented(LoginTask.class, username, password, webActions);
    }
}
