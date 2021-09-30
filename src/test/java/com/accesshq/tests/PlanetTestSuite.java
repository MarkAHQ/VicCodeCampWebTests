package com.accesshq.tests;

import com.accesshq.ui.HomePage;
import com.accesshq.ui.PlanetsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlanetTestSuite {

    private ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, -1000));
        driver.manage().window().maximize();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }

    @Test
    public void jupitersDistanceTest() {
        // Act
        new HomePage(driver).clickPlanetsButton();
        var planetsPage = new PlanetsPage(driver);
        var planet = planetsPage.getPlanet("Jupiter");

        // Assert
        Assertions.assertEquals(778500000, planet.getDistance());
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
