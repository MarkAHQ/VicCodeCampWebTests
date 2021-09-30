package com.accesshq.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormsPage {
    private final WebDriver driver;

    public FormsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSubmit() {
        for (var button : driver.findElements(By.tagName("button"))) {
            if (button.getText().equalsIgnoreCase("submit")) {
                button.click();
                break;
            }
        }
    }

    public boolean isEmailErrDisplayed() {
        return getElementErrElement("email").isDisplayed();
    }

    public boolean isNameErrDisplayed() {
        return getElementErrElement("name").isDisplayed();
    }

    public boolean isAgreeErrDisplayed() {
        return getElementErrElement("agree").isDisplayed();
    }

    public void setName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    private WebElement getElementErrElement(String errorId) {
        return driver.findElement(By.id(errorId + "err"));
    }

    public void setEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void clickAgree() {
        driver.findElement(By.cssSelector("[for=agree]")).click();
    }

    public ExpectedCondition<WebElement> isPopMessageVisible() {
        return ExpectedConditions.visibilityOf(getPopupMessageBox());
    }

    public WebElement getPopupMessageBox() {
        return driver.findElement(By.className("popup-message"));
    }
}