package com.accesshq.ui;

import com.accesshq.strategies.MatchingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlanetsPage {

    private final WebDriver driver;

    public PlanetsPage(WebDriver driver) {
        this.driver = driver;
    }

    public PlanetTile getPlanet(Predicate<PlanetTile> predicate) {
        for (WebElement planet : driver.findElements(By.className("planet"))) {
            var planetTile = new PlanetTile(planet);
            if (predicate.test(planetTile)) {
                return planetTile;
            }
        }

        throw new NotFoundException("Could not find planet");
    }

    public List<PlanetTile> getPlanetTiles() {
        List<PlanetTile> result = new ArrayList<>();
        for (WebElement element:driver.findElements(By.className("planet"))) {
            result.add(new PlanetTile(element));
        }

        return result;
    }
}