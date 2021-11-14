package cz.mendelu.xpaseka.pj.projekt.greenfoot;

import cz.mendelu.xpaseka.pj.projekt.Game;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.deckBuilding.DeckBuildingWorld;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.factionSelection.FactionChoiceWorld;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.gwintGame.GwintWorld;
import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.awt.*;

public abstract class Button extends Actor {
    private Button() {
        updateImage();
    }

    public abstract void act();
    public abstract void setActive(boolean active);
    public abstract void updateImage();

    public static Button createNewBuildButton = new Button() {
        @Override
        public void act() {
            if (Greenfoot.mouseClicked(this)) {
                Greenfoot.setWorld(new FactionChoiceWorld());
            }
        }

        @Override
        public void setActive(boolean active) {

        }

        @Override
        public void updateImage() {
            setImage("images/Buttons/button_active.png");
            getImage().setFont(getImage().getFont().deriveFont(18f));
            getImage().setColor(Color.WHITE);
            getImage().drawString("Create new build", 21,32);
        }
    };

    public static Button showGameRulesButton = new Button() {
        @Override
        public void act() {
            if (Greenfoot.mouseClicked(this)) {
                Greenfoot.setWorld(new GameRulesWorld());
            }
        }

        @Override
        public void setActive(boolean active) {

        }

        @Override
        public void updateImage() {
            setImage("images/Buttons/button_active.png");
            getImage().setFont(getImage().getFont().deriveFont(18f));
            getImage().setColor(Color.WHITE);
            getImage().drawString("How to play", 40,32);
        }
    };

    public static Button mainMenuButton = new Button() {
        @Override
        public void act() {
            if (Greenfoot.mouseClicked(this)) {
                Greenfoot.setWorld(new MainMenuWorld());
            }
        }

        @Override
        public void setActive(boolean active) {

        }

        @Override
        public void updateImage() {
            setImage("images/Buttons/button_active.png");
            getImage().setFont(getImage().getFont().deriveFont(18f));
            getImage().setColor(Color.WHITE);
            getImage().drawString("Main menu", 19,32);
        }
    };

    public static Button playButton = new Button() {
        private boolean active;

        @Override
        public void act() {
            if (Greenfoot.mouseClicked(this) && active) {
                Game.getPlayer().setHand();
                Greenfoot.setWorld(new GwintWorld());
            }
        }

        @Override
        public void updateImage() {
            if (active) setImage("images/Buttons/startGame_active.png");
            else setImage("images/Buttons/startGame_notactive.png");
        }

        @Override
        public void setActive(boolean active) {
            this.active = active;
            updateImage();
        }
    };

    public static Button saveButton = new Button() {
        private boolean active;

        @Override
        public void act() {
            if (Greenfoot.mouseClicked(this) && active) {
                String buildName = Greenfoot.ask("Name of build: ");
                Game.saveBuild(buildName);
            }
        }

        @Override
        public void updateImage() {
            if (active) setImage("images/Buttons/saveDeck_active.png");
            else setImage("images/Buttons/saveDeck_notactive.png");
        }

        @Override
        public void setActive(boolean active) {
            this.active = active;
            updateImage();
        }
    };

    public static Button loadButton = new Button() {
        @Override
        public void act() {
            if (Greenfoot.mouseClicked(this)) {
                String buildName = Greenfoot.ask("Name of build: ");
                Game.loadBuild(buildName);
                Greenfoot.setWorld(new DeckBuildingWorld());
            }
        }

        @Override
        public void updateImage() {
            setImage("images/Buttons/button_active.png");
            getImage().setFont(getImage().getFont().deriveFont(18f));
            getImage().setColor(Color.WHITE);
            getImage().drawString("Load build", 46,32);
        }

        @Override
        public void setActive(boolean active) {
//            this.active = active;
//            updateImage();
        }
    };
}
