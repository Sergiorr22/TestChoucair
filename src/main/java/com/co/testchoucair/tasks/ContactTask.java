package com.co.testchoucair.tasks;

import com.co.testchoucair.ui.RecruitmentPage;
import com.co.testchoucair.utilities.WebActions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ContactTask implements Task {


    private final String email;
    private final String number;
    private final WebActions webActions;

    public ContactTask(String email, String number, WebActions webActions){
        this.email = email;
        this.number = number;
        this.webActions = webActions;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                webActions.highlightElement(RecruitmentPage.INPUT_EMAIL),
                webActions.writeText(RecruitmentPage.INPUT_EMAIL, email),
                webActions.highlightElement(RecruitmentPage.INPUT_NUMBER),
                webActions.writeText(RecruitmentPage.INPUT_NUMBER, number)
        );
    }

    public static ContactTask withContact(String email, String number, WebActions webActions){
        return Tasks.instrumented(ContactTask.class, email, number, webActions);
    }
}
