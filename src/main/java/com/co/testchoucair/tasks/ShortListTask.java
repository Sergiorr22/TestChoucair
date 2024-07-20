package com.co.testchoucair.tasks;

import com.co.testchoucair.ui.RecruitmentPage;
import com.co.testchoucair.utilities.WebActions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ShortListTask implements Task {

    private final WebActions webActions;

    public ShortListTask(WebActions webActions){
        this.webActions = webActions;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                webActions.waitForElement(RecruitmentPage.BTN_SHORTLIST),
                webActions.highlightElement(RecruitmentPage.BTN_SHORTLIST),
                webActions.clickButton(RecruitmentPage.BTN_SHORTLIST),
                webActions.waitForElement(RecruitmentPage.BTN_SAVE),
                webActions.highlightElement(RecruitmentPage.BTN_SAVE),
                webActions.clickButton(RecruitmentPage.BTN_SAVE)
        );
    }

    public static ShortListTask shortList(WebActions webActions){
        return Tasks.instrumented(ShortListTask.class, webActions);
    }


}
