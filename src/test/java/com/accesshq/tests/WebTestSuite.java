package com.accesshq.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTestSuite {

    @Test
    public void DemoTest() {
        // Arrange
        var driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");

        // Act
        var actualText = driver.findElement(By.cssSelector("h1.display-1")).getText();

        // Assert
        Assertions.assertEquals("Web Playground", actualText);

        driver.quit();
    }
}
