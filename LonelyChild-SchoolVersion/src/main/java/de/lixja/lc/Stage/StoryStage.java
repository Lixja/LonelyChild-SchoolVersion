package de.lixja.lc.Stage;

import de.lixja.lc.GObjects.Player;
import de.lixja.lc.Stage.Story.ForestStage;
import de.lixja.lc.Stage.Story.HomeStage;
import de.lixja.lc.Stage.Story.HouseOfHorrorsStage;
import de.lixja.lc.Stage.Story.WorldStage;

public class StoryStage extends Stage {

    @Override
    public void start() {
        Player player = game.getData().getPlayer();
        while (true) {
            if ((player.getPosition() < 100 && player.getPosition() >= 0) || (player.getPosition() >= 500 && player.getPosition() < 600)) {
                game.setStage(new ForestStage());
                askForPause();
            }
            if ((player.getPosition() < 200 && player.getPosition() >= 100) || (player.getPosition() >= 600 && player.getPosition() < 700)) {
                game.setStage(new HouseOfHorrorsStage());
                askForPause();
            }
            if ((player.getPosition() < 300 && player.getPosition() >= 200) || (player.getPosition() >= 700 && player.getPosition() < 800)) {
                game.setStage(new HomeStage());
                askForPause();
            }
            if (player.getPosition() == 800 || player.getPosition() == 999) {
                game.setStage(new WorldStage());

            }
        }
    }

    public void askForPause() {
        game.saveGameData();
        game.out.writeWall();
        game.out.writeWall();
        boolean answer = game.in.getInputWithQuestionYesNo("Do you wanna make a break?");
        if (answer) {
            System.exit(0);
        }
        game.out.writeWall();
        game.out.writeWall();
    }

}
