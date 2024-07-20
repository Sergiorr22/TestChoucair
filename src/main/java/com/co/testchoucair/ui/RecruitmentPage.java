package com.co.testchoucair.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RecruitmentPage extends PageObject {

    public static final Target BTN_RECRUITMENT = Target.the("getBtnRecruitment")
            .located(By.xpath("(//span[.='Recruitment'])[1]"));

    public static final Target BTN_ADD = Target.the("getBtnAdd")
            .located(By.xpath("//button[.=' Add ']"));

    public static final Target INPUT_FIRSTNAME= Target.the("getFirstName")
            .located(By.name("firstName"));

    public static final Target INPUT_MIDDLENAME = Target.the("getMiddleName")
            .located(By.name("middleName"));

    public static final Target INPUT_LASTNAME = Target.the("getLastName")
            .located(By.name("lastName"));

    public static final Target DROPDOWN = Target.the("getDropdown")
            .located(By.cssSelector(".oxd-select-text"));

    public static final Target DROPDOWN_OPTION = Target.the("getDropdownOption")
            .located(By.xpath("//span[.='Senior QA Lead']"));

    public static final Target INPUT_EMAIL = Target.the("getEmail")
            .located(By.xpath("//label[.='Email']//following::input[1]"));

    public static final Target INPUT_NUMBER = Target.the("getNumber")
            .located(By.xpath("//label[.='Contact Number']//following::input[1]"));

    public static final Target FILE_UPLOAD_INPUT = Target.the("getUploadInput")
            .located(By.xpath("//input[@type='file']"));

    public static final Target BTN_SAVE = Target.the("getSave")
            .located(By.xpath("//button[.=' Save ']"));

    public static final Target BTN_SHORTLIST = Target.the("getShortlist")
            .located(By.xpath("//button[.=' Shortlist ']"));

    public static final Target BTN_SCHEDULE = Target.the("getSchedule")
            .located(By.xpath("//button[@type='button' and text()=' Schedule Interview ']"));

    public static final Target INPUT_INTERVIEWTITLE = Target.the("getTitle")
            .located(By.xpath("//label[.='Interview Title']//following::input[1]"));

    public static final Target INPUT_INTERVIEW = Target.the("getInterview")
            .located(By.xpath("//input[@include-employees='onlyCurrent']"));

    public static final Target INPUT_DATE = Target.the("getDate")
            .located(By.xpath("//input[@placeholder='yyyy-dd-mm']"));


    public static final Target OPTION = Target.the("getOption")
            .located(By.xpath("//span[.='James  Butler']"));

    public static final Target BTN_PASSED = Target.the("getPassed")
            .located(By.xpath("//button[.=' Mark Interview Passed ']"));

    public static final Target BTN_OFFERJOB = Target.the("getOffer")
            .located(By.xpath("//button[.=' Offer Job ']"));

    public static final Target BTN_HIRE = Target.the("getHire")
            .located(By.xpath("//button[.=' Hire ']"));

//    public static final Target LBL_FORM = Target.the("getForm")
//            .located(By.xpath("(//div[@class='orangehrm-card-container'])[1]"));

    public static final Target CONFIRM_NAME = Target.the("")
            .located(By.xpath("//div[.='Name']//following::p[1]"));

    public static final Target CONFIRM_VACANCY = Target.the("getVacancy")
            .located(By.xpath("(//div[@data-v-957b4417]//p[contains(@class, 'oxd-text') and contains(@class, 'oxd-text--p')])[2]"));

    public static final Target CONFIRM_STATUS = Target.the("getStatus")
            .located(By.xpath("//p[.='Status: Hired']"));

}
