package com.co.testchoucair.tasks;

import com.co.testchoucair.ui.RecruitmentPage;
import com.co.testchoucair.utilities.WebActions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SaveTask implements Task {

    private final WebActions webActions;


    public SaveTask(WebActions webActions){
        this.webActions = webActions;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                webActions.scrollTo(RecruitmentPage.FILE_UPLOAD_INPUT),
                webActions.highlightElement(RecruitmentPage.BTN_SAVE),
                webActions.clickButton(RecruitmentPage.BTN_SAVE)
        );
    }

    public static SaveTask Saving(WebActions webActions){
        return Tasks.instrumented(SaveTask.class, webActions);
    }
}
