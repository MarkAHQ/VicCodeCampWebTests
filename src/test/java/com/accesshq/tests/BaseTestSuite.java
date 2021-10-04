package com.accesshq.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTestSuite {
    protected ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        //driver.manage().window().setPosition(new Point(0, -1000));
        driver.manage().window().maximize();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
