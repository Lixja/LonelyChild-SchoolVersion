package de.lixja.lc.Stage;

import de.lixja.lc.GObjects.Player;
import de.lixja.lc.Stage.Story.ForestStage;

public class StoryStage extends Stage {

    @Override
    public void start() {
        Player player = game.getData().getPlayer();
        while (true) {
            if((player.getPosition() < 100 && player.getPosition() >= 0) || (player.getPosition() >= 500 && player.getPosition() < 600)){
                game.setStage(new ForestStage());
            }

            game.saveGameData();
        }
    }

}
