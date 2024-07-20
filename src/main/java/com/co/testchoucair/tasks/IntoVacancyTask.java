package com.co.testchoucair.tasks;

import com.co.testchoucair.ui.RecruitmentPage;
import com.co.testchoucair.ui.VacancyPage;
import com.co.testchoucair.utilities.WebActions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

public class IntoVacancyTask implements Task {

    private final WebActions webActions;


    public IntoVacancyTask(WebActions webActions){
        this.webActions = webActions;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                webActions.highlightElement(RecruitmentPage.BTN_RECRUITMENT),
                webActions.clickButton(RecruitmentPage.BTN_RECRUITMENT),
                webActions.waitForElement(VacancyPage.LBL_VACANCY),
                webActions.highlightElement(VacancyPage.LBL_VACANCY),
                webActions.clickButton(VacancyPage.LBL_VACANCY),
                webActions.waitForElement(VacancyPage.BTN_EDIT),
                webActions.scrollTo(VacancyPage.BTN_EDIT),
                webActions.highlightElement(VacancyPage.BTN_EDIT),
                webActions.clickButton(VacancyPage.BTN_EDIT),
                webActions.waitForElement(VacancyPage.INPUT_HIRING),
                webActions.clickButton(VacancyPage.INPUT_HIRING),
                webActions.writeText(VacancyPage.INPUT_HIRING, "James"),
                webActions.waitForElement(RecruitmentPage.OPTION),
                webActions.clickButton(RecruitmentPage.OPTION),
                webActions.scrollTo(RecruitmentPage.BTN_SAVE),
                webActions.highlightElement(RecruitmentPage.BTN_SAVE),
                webActions.clickButton(RecruitmentPage.BTN_SAVE)
        );
    }

    public static IntoVacancyTask fixVacancy(WebActions webActions){
        return Tasks.instrumented(IntoVacancyTask.class, webActions);
    }

}
