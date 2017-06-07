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
import de.lixja.lc.Stage.Stage;

/**
 *
 * @author Dimitrios Diamantidis &lt;Dimitri.dia@ledimi.com&gt;
 */
public class HouseOfHorrorsStage extends Stage {

    private Player player;

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
        while ((player.getPosition() < 200 && player.getPosition() >= 100) || (player.getPosition() >= 600 && player.getPosition() < 700)) {
            switch (player.getPosition()) {
                case 100:
                    zero();
                    break;
                case 101:
                    one();
                    break;
                case 600:
                    gzero();
                    break;
                case 601:
                    gone();
                    break;
            }
            game.saveGameData();
        }
    }

    private void zero() {
        game.out.writeS("*Walking ... Walking*\n"
                + "After several hours you found your way out of the forest.\n"
                + "You see a big house.\n"
                + "The door is open.\n"
                + "You enter...\n"
                + "The door closes immediatly\n"
                + "You can't leave.\n"
                + "You hear a voice.\n\n"
                + "Welcome to the house of horros.\n"
                + "You know you have to leave...\n\n");
        player.setPosition(101);
    }

    private void one() {

    }

    private void gzero() {
        game.out.writeS("*Walking ... Walking*\n");
        if (player.isConsistsFlowey()) {
            game.out.writeS("After several hours you and flowey found your way out of the forest.\n");
        } else {
            game.out.writeS("After several hours you found your way out of the forest.\n");
        }
        game.out.writeS("You see a big house.\n"
                + "The door is open.\n"
                + "You enter...\n"
                + "The door closes immediatly\n"
                + "You can't leave.\n"
                + "You hear a voice.\n\n"
                + "Welcome dear friend.\n"
                + "This is your new home lost soul.\n");
        player.setPosition(601);
    }

    private void gone() {

    }

}
