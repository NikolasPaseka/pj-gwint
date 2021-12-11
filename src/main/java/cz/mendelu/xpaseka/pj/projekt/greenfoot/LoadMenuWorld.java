package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.deckBuilding.DeckBuildingWorld;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadMenuWorld extends World {
    public LoadMenuWorld() {
        super(1600, 900, 1);
        setBackground("images/background.png");
        addObject(Button.mainMenuButton, 1400, 800);
        addObject(new Actor() {
            {
                setImage(new GreenfootImage("Select your saved build:", 35, Color.WHITE, null));
            }
        }, 800, 100);
        renderLoads();
    }

    private void renderLoads() {
        var loadFiles = new File("saves").list((dir, name) -> name.matches(".*[.]player"));
        if (loadFiles != null) {
            int coorY = 100;
            int i = 0;
            int columns = (loadFiles.length / 7);
            int coorX = 800 - columns*200;
            for (String loadFile : loadFiles) {
                if (i == 6) {
                    coorY = 100;
                    coorX += 200;
                }
                addObject(new LoadBuildButton(loadFile.split("[.]")[0]), coorX, coorY += 100);
                i++;
            }
        }
    }
}
