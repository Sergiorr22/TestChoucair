package com.co.testchoucair.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    public static final Target LBL_USERNAME = Target.the("getLblUsername")
            .located(By.name("username"));

    public static final Target LBL_PASSWORD = Target.the("getLblPassword")
            .located(By.name("password"));

    public static final Target BTN_LOGIN = Target.the("getBtnLogin")
            .located(By.xpath("//button[.=' Login ']"));

}
