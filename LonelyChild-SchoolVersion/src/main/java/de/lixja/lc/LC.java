package de.lixja.lc;

import de.lixja.lc.Stage.BootStage;
import de.lixja.lc.game.Game;

public class LC {

    public static void main(String[] args) {
            Game game = new Game();
            game.setStage(new BootStage());
    }
}
