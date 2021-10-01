package com.accesshq.tests;

import com.accesshq.strategies.NameMatch;
import com.accesshq.ui.HomePage;
import com.accesshq.ui.PlanetTile;
import com.accesshq.ui.PlanetsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;

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
        var planet = planetsPage.getPlanet(planetTile -> planetTile.getName().equalsIgnoreCase("Jupiter"));

        // Assert
        Assertions.assertEquals(778500000, planet.getDistance());
    }

    @Test
    public void furthestDistanceTest() {
        var planetsPage = new HomePage(driver).clickPlanetsButton();

        PlanetTile furthestPlanet = planetsPage.getPlanetTiles()
                .stream()
                .max((o1, o2) -> (int) (o2.getDistance() - o1.getDistance()))
                .get();
        
        Assertions.assertEquals("Neptune", furthestPlanet.getName());
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
