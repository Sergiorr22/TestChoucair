package com.co.testchoucair.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage extends PageObject {

    public static final Target LBL_DASHBOARD = Target.the("getLblDashboard")
            .located(By.xpath("//h6[.='Dashboard']"));

}
