package com.accesshq.tests;

import com.accesshq.ui.FormsPage;
import com.accesshq.ui.HomePage;
import com.accesshq.utils.WaitHelper;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.util.List;

public class WebTests extends BaseTestSuite {
    @Test
    public void demoTest() {
        // Act
        var actualText = driver.findElement(By.cssSelector("h1.display-1")).getText();

        // Assert
        Assertions.assertEquals("Web Playground", actualText);

        driver.quit();
    }

    @Test
    public void tableQuantityTest() {
        // Act
        var tableElement = driver.findElement(By.tagName("table"));
        List<WebElement> inputElements = tableElement.findElements(By.tagName("input"));

        // Assert
        Assertions.assertEquals(1, Integer.parseInt(inputElements.get(0).getAttribute("value")));
    }

    @Test
    public void movingButtonTest() {
        // Arrange

        // Act
        var upDownButton = getUpDownButton();
        upDownButton.click();

        // Assert
        String expected = "CLICK ME UP!";
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(upDownButton, expected));
        Assertions.assertEquals(expected, upDownButton.getText());
    }

    private WebElement getUpDownButton() {
        return driver.findElement(By.cssSelector("a[role=button]"));
    }

    @Test
    public void formSubmitTest() {
        // Arrange
        new HomePage(driver).clickFormsButton();

        // Act
        var name = "Mark Arnold";
        var formsPage = new FormsPage(driver);
        formsPage.setName(name);
        formsPage.setEmail("mark.arnold@accesshq.com");
        formsPage.clickAgree();
        formsPage.clickSubmit();
        WaitHelper.RunWithoutImplicitWait(driver, () ->
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(formsPage.getPopupMessageBox()))
        );

        // Assert
        Assertions.assertEquals("Thanks for your feedback " + name,
                formsPage.getPopupMessageBox().getText());
    }

    @Test
    public void errorMessagesTest() {
        // Arrange
        new HomePage(driver).clickFormsButton();

        // Act
        var formsPage = new FormsPage(driver);
        formsPage.clickSubmit();

        // Assert
        Assertions.assertTrue(formsPage.isNameErrDisplayed());
        Assertions.assertTrue(formsPage.isEmailErrDisplayed());
        Assertions.assertTrue(formsPage.isAgreeErrDisplayed());
    }
}