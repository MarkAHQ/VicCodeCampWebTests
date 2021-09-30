package com.accesshq.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanetsPage {

    private final WebDriver driver;

    public PlanetsPage(WebDriver driver) {
        this.driver = driver;
    }

    public PlanetTile getPlanet(String planetName) {
        for (WebElement planet : driver.findElements(By.className("planet"))) {
            var planetTile = new PlanetTile(planet);
            if(planetTile.getName().equalsIgnoreCase(planetName)) {
                return planetTile;
            }
        }

        throw new NotFoundException("Could not find planet " + planetName);
    }
}
