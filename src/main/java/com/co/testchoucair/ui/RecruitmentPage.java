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


}
