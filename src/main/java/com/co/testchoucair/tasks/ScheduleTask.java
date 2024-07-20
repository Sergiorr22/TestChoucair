package com.co.testchoucair.tasks;

import com.co.testchoucair.ui.RecruitmentPage;
import com.co.testchoucair.utilities.WebActions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ScheduleTask implements Task {

    private final String intTitle;
    private final String interviewer;
    private final String currentDate;
    private final WebActions webActions;

    public ScheduleTask(String intTitle, String interviewer, String currentDate, WebActions webActions){
        this.intTitle = intTitle;
        this.interviewer = interviewer;
        this.currentDate = currentDate;
        this.webActions = webActions;
    }

    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                webActions.waitForElement(RecruitmentPage.BTN_SCHEDULE),
                webActions.highlightElement(RecruitmentPage.BTN_SCHEDULE),
                webActions.clickButton(RecruitmentPage.BTN_SCHEDULE),
                webActions.waitForElement(RecruitmentPage.INPUT_INTERVIEWTITLE),
                webActions.highlightElement(RecruitmentPage.INPUT_INTERVIEWTITLE),
                webActions.writeText(RecruitmentPage.INPUT_INTERVIEWTITLE, intTitle),
                webActions.clickButton(RecruitmentPage.INPUT_INTERVIEW),
                Enter.theValue(interviewer).into(RecruitmentPage.INPUT_INTERVIEW),
                webActions.waitForElement(RecruitmentPage.OPTION),
                webActions.clickButton(RecruitmentPage.OPTION),
                webActions.highlightElement(RecruitmentPage.INPUT_DATE),
                webActions.writeText(RecruitmentPage.INPUT_DATE, currentDate),
                webActions.scrollTo(RecruitmentPage.BTN_SAVE),
                webActions.highlightElement(RecruitmentPage.BTN_SAVE),
                webActions.clickButton(RecruitmentPage.BTN_SAVE)
        );
    }

    public static ScheduleTask enterForm(String intTitle, String interviewer, String currentDate, WebActions webActions){
        return Tasks.instrumented(ScheduleTask.class, intTitle, interviewer, currentDate, webActions);
    }





}
