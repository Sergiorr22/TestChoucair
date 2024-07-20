package com.co.testchoucair.stepdefinitions;

import com.co.testchoucair.questions.VerifyText;
import com.co.testchoucair.tasks.*;
import com.co.testchoucair.ui.RecruitmentPage;
import com.co.testchoucair.utilities.WebActions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.equalTo;

public class CandidatesDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;
    Actor user = Actor.named("User");
    private WebActions webActions;

    @Before
    public void setUp(){
        user.can(BrowseTheWeb.with(driver));
    }

    @And("the user logs in to recruitment, clicks on add and enters his full name, firstname {string} middlename {string} and last name {string}")
    public void theUserLogsInToRecruitmentClicksOnAddAndEntersHisFullNameFirstnameMiddlenameAndLastName(String firstname, String middlename, String lastname) {
        user.attemptsTo(RegisterNameTask.withCredentials(firstname, middlename, lastname, webActions));
    }

    @And("the user selects the vacancy")
    public void theUserSelectsTheVacancy() {
        user.attemptsTo(
                ListTask.selectOption(RecruitmentPage.DROPDOWN, RecruitmentPage.DROPDOWN_OPTION)
        );
    }

    @And("user enters email {string} and contact number {string}")
    public void userEntersEmailAndContactNumber(String email, String number) {
        user.attemptsTo(ContactTask.withContact(email, number, webActions));
    }

    @And("the user uploads his CV")
    public void theUserUploadsHisCV() {
        String filePath = "src/test/resources/files/CvSergio.pdf";
        user.attemptsTo(
                UploadTask.withFile(RecruitmentPage.FILE_UPLOAD_INPUT, filePath, webActions)
        );
    }

    @And("user saves the record")
    public void userSavesTheRecord() {
        user.attemptsTo(SaveTask.Saving(webActions));
    }

    @And("The user clicks on shortlist and saves")
    public void theUserClicksOnShortlistAndSaves() {
        user.attemptsTo(ShortListTask.shortList(webActions));
    }

    @And("The user clicks on schedule and fills out the data {string}, {string}, {string}")
    public void theUserClicksOnScheduleAndFillsOutTheData(String intTitle, String interviewer, String currentDate) {
        user.attemptsTo(ScheduleTask.enterForm(intTitle, interviewer, currentDate, webActions));
    }

    @And("the user completes the candidate process")
    public void theUserCompletesTheCandidateProcess() {
        user.attemptsTo(FinishTask.finish(webActions));
    }

    @Then("the user should see the name {string}, vacancy {string}, and status Hired")
    public void theUserShouldSeeTheNameVacancyAndStatus(String expectedName, String expectedVacancy) {
        user.should(
                GivenWhenThen.seeThat("Name is correct", VerifyText.forTarget(RecruitmentPage.CONFIRM_NAME, expectedName, webActions), equalTo(true)),
                GivenWhenThen.seeThat("Vacancy is correct", VerifyText.forTarget(RecruitmentPage.CONFIRM_VACANCY, expectedVacancy, webActions), equalTo(true)),
                GivenWhenThen.seeThat("Status is correct", VerifyText.forTarget(RecruitmentPage.CONFIRM_STATUS, "Status: Hired", webActions), equalTo(true))
        );
    }
}
