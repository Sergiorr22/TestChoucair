package com.co.testchoucair.tasks;

import com.co.testchoucair.ui.RecruitmentPage;
import com.co.testchoucair.utilities.WebActions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class RegisterNameTask implements Task {


    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final WebActions webActions;


    public RegisterNameTask(String firstname, String middlename, String lastname, WebActions webActions) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.webActions = webActions;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                webActions.highlightElement(RecruitmentPage.BTN_RECRUITMENT),
                webActions.clickButton(RecruitmentPage.BTN_RECRUITMENT),
                webActions.highlightElement(RecruitmentPage.BTN_ADD),
                webActions.clickButton(RecruitmentPage.BTN_ADD),
                webActions.highlightElement(RecruitmentPage.INPUT_FIRSTNAME),
                webActions.writeText(RecruitmentPage.INPUT_FIRSTNAME, firstname),
                webActions.highlightElement(RecruitmentPage.INPUT_MIDDLENAME),
                webActions.writeText(RecruitmentPage.INPUT_MIDDLENAME, middlename),
                webActions.highlightElement(RecruitmentPage.INPUT_LASTNAME),
                webActions.writeText(RecruitmentPage.INPUT_LASTNAME, lastname)
        );
    }

    public static RegisterNameTask withCredentials(String firstname, String middlename, String lastname, WebActions webActions){
        return Tasks.instrumented(RegisterNameTask.class, firstname, middlename, lastname, webActions);
    }

}
