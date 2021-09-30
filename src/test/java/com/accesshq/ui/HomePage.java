package com.accesshq.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFormsButton() {
        driver.findElement(By.cssSelector("[aria-label=forms]")).click();
    }

    public void clickPlanetsButton() {
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();
    }
}
