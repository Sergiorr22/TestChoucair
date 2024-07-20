package com.co.testchoucair.tasks;

import com.co.testchoucair.ui.RecruitmentPage;
import com.co.testchoucair.utilities.WebActions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import javax.swing.plaf.PanelUI;

public class FinishTask implements Task {
    private final WebActions webActions;

    public FinishTask(WebActions webActions){
        this.webActions = webActions;
    }

    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                webActions.waitForElement(RecruitmentPage.BTN_PASSED),
                webActions.highlightElement(RecruitmentPage.BTN_PASSED),
                webActions.clickButton(RecruitmentPage.BTN_PASSED),
                webActions.waitForElement(RecruitmentPage.BTN_SAVE),
                webActions.highlightElement(RecruitmentPage.BTN_SAVE),
                webActions.clickButton(RecruitmentPage.BTN_SAVE),
                webActions.waitForElement(RecruitmentPage.BTN_OFFERJOB),
                webActions.highlightElement(RecruitmentPage.BTN_OFFERJOB),
                webActions.clickButton(RecruitmentPage.BTN_OFFERJOB),
                webActions.waitForElement(RecruitmentPage.BTN_SAVE),
                webActions.highlightElement(RecruitmentPage.BTN_SAVE),
                webActions.clickButton(RecruitmentPage.BTN_SAVE),
                webActions.waitForElement(RecruitmentPage.BTN_HIRE),
                webActions.highlightElement(RecruitmentPage.BTN_HIRE),
                webActions.clickButton(RecruitmentPage.BTN_HIRE),
                webActions.waitForElement(RecruitmentPage.BTN_SAVE),
                webActions.highlightElement(RecruitmentPage.BTN_SAVE),
                webActions.clickButton(RecruitmentPage.BTN_SAVE)
        );


    }

    public static FinishTask finish(WebActions webActions){
        return Tasks.instrumented(FinishTask.class, webActions);
    }

}
