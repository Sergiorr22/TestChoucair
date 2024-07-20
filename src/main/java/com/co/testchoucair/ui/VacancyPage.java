package com.co.testchoucair.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VacancyPage extends PageObject {

    public static final Target LBL_VACANCY = Target.the("getVacancy")
            .located(By.xpath("//a[.='Vacancies']"));

    public static final Target BTN_EDIT = Target.the("getEdit")
            .located(By.xpath("//div[.='Senior QA Lead']//following::i[2]"));

    public static final Target INPUT_HIRING = Target.the("getHiring")
            .located(By.xpath("//label[.='Hiring Manager']//following::input[1]"));

}
