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

import de.lixja.lc.GObjects.Deamon;
import de.lixja.lc.GObjects.Ghost;
import de.lixja.lc.GObjects.Mystery;
import de.lixja.lc.GObjects.Player;
import de.lixja.lc.GObjects.Soul;
import de.lixja.lc.GObjects.Vampir;
import de.lixja.lc.GObjects.Werewolf;
import de.lixja.lc.Stage.FightStage;
import de.lixja.lc.Stage.Stage;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
                case 102:
                    two();
                case 103:
                    three();
                    break;
                case 600:
                    gzero();
                    break;
                case 601:
                    gone();
                    break;
                case 602:
                    gtwo();
                    break;
                case 603:
                    gthree();
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
        game.out.writeWall();
        List<String> options;
        if (player.isSavedSoul()) {
            options = Arrays.asList("Look around", "Call for help", "Hit the door");
        } else {
            options = Arrays.asList("Look around", "Scream", "Hit the door");
        }
        int answer = game.in.getInputWithOptionsH(options, "What do you wanna do?");
        switch (answer) {
            case 0:
                player.setPosition(102);
                break;
            case 1:
                if (!player.isSavedSoul()) {
                    game.out.writeS("You hear a scream from somebody else.");
                    if (game.setStage(new FightStage(new Soul())) == 1) {
                        player.kill(8);
                        player.setPosition(603);
                    } else {
                        player.setSavedSoul(true);
                    }
                } else {
                    player.setPosition(103);
                }
                break;
            case 2:
                game.out.writeS("You hit the door\n"
                        + ". . .\n"
                        + "Nothing happened.");
                break;
        }
    }

    private void two() {
        Random rn = new Random();
        rn.setSeed(new Date().getTime());
        game.out.writeS("You look around.");
        game.out.writeSlow(". . .", 500);
        int answer = (int) (rn.nextDouble() * 4);
        if (answer == 0) {
            if (game.setStage(new FightStage(new Ghost())) == 1) {
                player.kill(5);
                player.setPosition(601);
            } else {
                player.setPosition(101);
            }
        } else if (answer == 1) {
            if (game.setStage(new FightStage(new Vampir())) == 1) {
                player.setPosition(601);
                player.kill(6);
            } else {
                player.setPosition(101);
            }
        } else if (answer == 2) {
            if (game.setStage(new FightStage(new Werewolf())) == 1) {
                player.kill(7);
                player.setPosition(601);
            } else {
                player.setPosition(101);
            }
        }
    }

    private void three() {
        game.out.writeS("A soul appeared to help you.\n"
                + "You close your eyes.\n"
                + "You open them again.\n"
                + "You see\n"
                + "You see your ... home.\n\n"
                + "Why am i back at this place you ask.\n"
                + "Soul: Believe me, this time things will change.");
        player.setPosition(200);
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
        game.out.writeWall();
        List<String> options;
        if (player.isConsistsFlowey()) {
            options = Arrays.asList("Look around", "Hit the door", "Destroy the door");
        } else {
            options = Arrays.asList("Look around", "Hit the door");
        }
        int answer = game.in.getInputWithOptionsH(options, "What do you wanna do?");
        switch (answer) {
            case 0:
                player.setPosition(602);
                break;
            case 1:
                game.out.writeS("You hit the door\n"
                        + ". . .\n"
                        + "Nothing happened.");
                break;
            case 2:
                game.out.writeS("You and flowey destroy the door.\n"
                        + "Something appears in front of you.\n");
                if (game.setStage(new FightStage(new Mystery())) == 1) {
                    player.kill(9);
                    player.setPosition(601);
                    game.out.writeS("Mystery built a new door.");
                } else {
                    player.setPosition(601);
                }
                break;
        }
    }

    private void gtwo() {
        Random rn = new Random();
        rn.setSeed(new Date().getTime());
        game.out.writeS("You look around.");
        game.out.writeSlow(". . .", 500);
        int answer = (int) (rn.nextDouble() * 4);
        if (answer == 0) {
            if (game.setStage(new FightStage(new Ghost())) == 1) {
                player.kill(5);
                player.setPosition(601);
            } else {
                player.setPosition(601);
            }
        } else if (answer == 1) {
            if (game.setStage(new FightStage(new Vampir())) == 1) {
                player.setPosition(601);
                player.kill(6);
            } else {
                player.setPosition(601);
            }
        } else if (answer == 2) {
            if (game.setStage(new FightStage(new Werewolf())) == 1) {
                player.kill(7);
                player.setPosition(601);
            } else {
                player.setPosition(601);
            }
        } else if (answer == 3) {
            if (game.setStage(new FightStage(new Soul())) == 1) {
                player.kill(8);
                player.setPosition(603);
            } else {
                player.setPosition(200);
            }
        }
    }

    public void gthree() {
        if (game.setStage(new FightStage(new Deamon())) == 1) {
            player.setPosition(604);
        }
    }
    
    public void gfour(){
        game.out.writeS("The house starts to burn.\n"
                + "Mystery opens the doort.\n"
                + "You left the house.\n"
                + "After some minutes there is no house at this place any more.\n"
                + "There is only a deamon\n\n");
        game.out.writelnSlow("YOU", 200);
        player.setPosition(700);
    }
}
