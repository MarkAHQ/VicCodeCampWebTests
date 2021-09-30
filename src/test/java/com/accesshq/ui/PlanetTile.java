package com.accesshq.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;

public class PlanetTile {
    private final WebElement thisElement;

    public PlanetTile(WebElement planetTileElement) {
        thisElement = planetTileElement;
    }

    public String getName() {
        return thisElement.findElement(By.className("name")).getText();
    }

    public long getDistance() {
        var distanceString = thisElement.findElement(By.className("distance")).getText();
        distanceString = distanceString.split(" ")[0];
        try {
            return NumberFormat.getNumberInstance().parse(distanceString).longValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        throw new NotFoundException();
    }
}
