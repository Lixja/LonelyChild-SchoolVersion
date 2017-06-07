/*
 * Copyright (C) 2017 Dimitrios Diamantidis &lt;Dimitri.dia@ledimi.com&gt;
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.lixja.lc.Stage.Story;

import de.lixja.lc.GObjects.Player;
import de.lixja.lc.GObjects.Pupil;
import de.lixja.lc.Stage.FightStage;
import de.lixja.lc.Stage.Stage;

/**
 *
 * @author Dimitrios Diamantidis &lt;Dimitri.dia@ledimi.com&gt;
 */
public class HomeStage extends Stage {

    Player player;

    /*
        WARNING
        UnreadableCodeException
        
        WAIT!!!
        THIS CODE IS NOT VERY READABLE.
        IF YOU WANT TO PROTECT YOUR EYES CLOSE THIS FILE!!!
        THAT IS FOR YOUR OWN SAFETY.
     */
    @Override
    public void start() {
        player = game.getData().getPlayer();
        while ((player.getPosition() < 300 && player.getPosition() >= 200) || (player.getPosition() >= 700 && player.getPosition() < 800)) {
            switch (player.getPosition()) {
                case 200:
                    zero();
                    break;
                    
                case 700:
                    gzero();
                    break;
            }
        }
    }
    
    private void zero(){
        game.out.writeS("I am back home...\n"
                + "I can't go there.\n"
                + "They hate me.\n"
                + "It will all start from the begining.\n"
                + "Mother: "+player.getName()+"!!!\n"
                        + "Mother: You are back...\n");
    }
    
    private void gzero(){
        game.out.writeS("You reached your home town.\n"
                + "You see some Pupils that bullied you.\n");
        if(player.isConsistsFlowey()){
            game.out.writeS("Let's kill them.");
        }
        if(game.setStage(new FightStage(new Pupil())) == 1){
            player.kill(10);
        }
    }
}
