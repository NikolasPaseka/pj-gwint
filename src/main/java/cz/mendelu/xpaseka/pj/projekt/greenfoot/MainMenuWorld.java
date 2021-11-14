package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import greenfoot.World;

public class MainMenuWorld extends World {
    public MainMenuWorld() {
        super(1600, 900, 1);
        setBackground("images/main-menu.png");

        addObject(Button.createNewBuildButton, 800, 600);
        addObject(Button.loadButton, 800, 680);
        addObject(Button.showGameRulesButton, 800, 760);
    }
}
