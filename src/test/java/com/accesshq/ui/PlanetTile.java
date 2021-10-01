package com.accesshq.ui;

import com.accesshq.utils.StringParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        return StringParser.KmsToLong(distanceString);
    }
}
