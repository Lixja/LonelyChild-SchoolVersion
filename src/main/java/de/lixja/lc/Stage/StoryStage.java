package de.lixja.lc.Stage;

import de.lixja.lc.GObjects.MasterStone;

public class StoryStage extends Stage {
    
    @Override
    public void start(){
        switch(game.getData().getPlayer().getPosition()){
            case 0:
                game.setStage(new FightStage(new MasterStone()));
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }

}
