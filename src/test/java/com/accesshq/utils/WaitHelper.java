package com.accesshq.utils;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WaitHelper {

    public static void RunWithoutImplicitWait(WebDriver driver, Runnable codeToRun) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        codeToRun.run();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
