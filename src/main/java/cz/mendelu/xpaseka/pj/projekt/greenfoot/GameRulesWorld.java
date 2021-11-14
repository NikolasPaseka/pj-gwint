package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import com.sun.tools.javac.Main;
import cz.mendelu.xpaseka.pj.projekt.Game;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

import java.awt.*;
import java.util.function.Function;

public class GameRulesWorld extends World {
    public GameRulesWorld() {
        super(1600, 900, 1);
        addObject(Button.mainMenuButton, 1400, 800);
        renderFirstScreen();
    }

    public void renderFirstScreen() {
        setBackground("images/background.png");
        getBackground().setFont(getBackground().getFont().deriveFont(14f));
        getBackground().setColor(Color.white);

        getBackground().drawString(Game.getGameRules("prubeh-hry"), 150, 70);
        getBackground().drawString(Game.getGameRules("hraci-plan-a-karty"), 800, 70);
        addObject(new Actor() {
            {
                setImage("images/buttons/arrow_button_right.png");
            }

            @Override
            public void act() {
                if (Greenfoot.mouseClicked(this)) {
                    renderSecondScreen();
                    removeObject(this);
                }
            }
        }, 1500, 450);
    }

    public void renderSecondScreen() {
        setBackground("images/background.png");
        getBackground().setColor(Color.white);
        getBackground().setFont(getBackground().getFont().deriveFont(14f));

        getBackground().drawString(Game.getGameRules("jednotky-a-hrdinove"), 150, 70);
        getBackground().drawString(Game.getGameRules("frakce"), 800, 70);
        addObject(new Actor() {
            {
                setImage("images/buttons/arrow_button_left.png");
            }

            @Override
            public void act() {
                if (Greenfoot.mouseClicked(this)) {
                    renderFirstScreen();
                    removeObject(this);
                }
            }
        }, 100, 450);
    }
}