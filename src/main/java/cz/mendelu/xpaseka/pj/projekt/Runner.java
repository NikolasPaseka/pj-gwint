package cz.mendelu.xpaseka.pj.projekt;

import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.FactionChoiceWorld;
import cz.mendelu.xpaseka.pj.projekt.greenfoot.GwintWorld;

public class Runner extends GreenfootRunner {
    // provola se na zacatku pri volani tridy - da se hodit i do mainu
    static {
        bootstrap(Runner.class,
                Configuration.forWorld(FactionChoiceWorld.class)
                        .projectName("Gwint")
                        .hideControls(true)
        );
    }

    public static void main(String[] args) {
        GreenfootRunner.main(args);
    }
}
