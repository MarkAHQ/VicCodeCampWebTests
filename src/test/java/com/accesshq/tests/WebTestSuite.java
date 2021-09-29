package com.accesshq.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.util.List;

public class WebTestSuite {

    WebDriver driver;

    @BeforeEach
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }

    @Test
    public void DemoTest() {
        // Act
        var actualText = driver.findElement(By.cssSelector("h1.display-1")).getText();

        // Assert
        Assertions.assertEquals("Web Playground", actualText);

        driver.quit();
    }

    @Test
    public void TableQuantityTest() {
        // Act
        var tableElement = driver.findElement(By.tagName("table"));
        List<WebElement> inputElements = tableElement.findElements(By.tagName("input"));

        // Assert
        Assertions.assertEquals(5, Integer.parseInt(inputElements.get(0).getAttribute("value")));
    }

    @Test
    public void MovingButtonTest() {
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

    @AfterEach
    public void Cleanup() {
        driver.quit();
    }
}