package com.co.testchoucair.hooks;

import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.openqa.selenium.WebDriver;

public class TestHooks {

    @Managed
    WebDriver driver;

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
