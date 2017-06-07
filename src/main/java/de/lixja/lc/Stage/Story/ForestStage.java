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

import de.lixja.lc.GObjects.Flowey;
import de.lixja.lc.GObjects.MasterStone;
import de.lixja.lc.GObjects.Player;
import de.lixja.lc.GObjects.Snake;
import de.lixja.lc.GObjects.Tiger;
import de.lixja.lc.GObjects.Wolf;
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
public class ForestStage extends Stage {

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
        while ((player.getPosition() < 100 && player.getPosition() >= 0) || (player.getPosition() >= 500 && player.getPosition() < 600)) {
            switch (player.getPosition()) {
                case 0:
                    zero();
                    break;
                case 1:
                    one();
                    break;
                case 2:
                    two();
                    break;
                case 3:
                    three();
                    break;
                case 4:
                    four();
                    break;
                case 5:
                    five();
                    break;
                case 6:
                    six();
                    break;
                case 7:
                    seven();
                    break;
                case 8:
                    eight();
                    break;
                case 502:
                    gtwo();
                    break;
                case 503:
                    gthree();
                    break;
                case 504:
                    gfour();
                    break;
                case 505:
                    gfive();
                    break;
                case 506:
                    gsix();
                    break;
                case 507:
                    gseven();
                    break;
                case 508:
                    geight();
                    break;
                case 509:
                    gnine();
            }
            game.saveGameData();
        }
    }

    private void zero() {
        game.out.writeS("You look around.");
        game.sleep(1500);
        game.out.writeS("You don't know were you are.\n"
                + "You can't even remember the way or since when you were in a forest.\n"
                + "But you think know it's a better place.\n");
        game.out.writelnSlow(". . .", 500);
        game.out.writeS("You don't want to think, about what they did.\n"
                + "But you are still so angry!\n"
                + "You think you will get crazy.\n");
        game.sleep(500);
        game.out.writelnSlow("You hear a stone talking?", 120);
        player.setPosition(1);
    }

    private void one() {
        if (game.setStage(new FightStage(new MasterStone())) == 1) {
            player.kill(0);
            player.setPosition(502);
        } else {
            player.setPosition(2);
        }
    }

    private void two() {
        game.out.writeS("No.\n");
        game.sleep(500);
        game.out.writeS("I will not be like them.\n"
                + "I will be an other person\n"
                + "Even if they tortured me like that.\n");
        game.sleep(200);
        game.out.writeS("You ask the stone why you can hear him.\n\n"
                + "The stone tells you you are in the forest of dreams.\n"
                + "The only place on earth that can be enter by a poor soul.\n\n"
                + "You ask if somebody else is also on this place.\n\n"
                + "The stone tells you to follow him.\n\n"
                + "So you do\n\n"
                + "The stone introduces you Snake.\n\n\n"
                + "Snake: Why do you bring a human beeing to our place\n"
                + "Stone: He seemed friendly. He did not attack me.\n"
                + "Snake: He tricked you! A human can't be friendly!\n");
        player.setPosition(3);
    }

    private void three() {
        boolean choice = false;
        if (game.setStage(new FightStage(new Snake())) == 1) {
            player.kill(1);
            game.out.writeS("Stone: Why did you do that?");
            choice = game.in.getInputWithQuestionYesNo("Do you wanna fight Stone?");
            if (choice) {
                if (game.setStage(new FightStage(new MasterStone())) == 1) {
                    player.kill(0);
                    player.setPosition(504);
                    return;
                } else {
                    game.out.writeS("Stone flew.\n");
                }
                game.out.writeS("Stone flew.\n");
            }
            player.setPosition(504);
        } else {
            player.setPosition(4);
        }
    }

    private void four() {
        game.out.writeS("Snake: ...\n"
                + "Snake: I am sorry I attacked you.\n"
                + "Snake: Every human i saw until now was bad.\n"
                + "Snake: But you seem so different.\n");
        game.sleep(500);
        game.out.writeS("Snake: You are welcome to stay at this place.\n"
                + "Snake: But be careful, most beeings would attack you if they see you.\n"
                + "Snake: We hate humans. \n\n");
        player.setPosition(5);
    }

    private void five() {
        List<String> options;
        if (player.getKilled(0)) {  //Check if Stone is already killed.
            options = Arrays.asList("Look around.", "Search an exit", "Talk with the Snake");

        } else {
            options = Arrays.asList("Look around.", "Search an exit", "Talk with the Snake", "Talk with the Stone");

        }
        int answer = game.in.getInputWithOptionsV(options, "What do you wanna do?");
        switch (answer) {
            case 0:
                player.setPosition(6);
                break;
            case 1:
                player.setPosition(7);
                break;
            case 2:
                game.out.writeS("Snake: Go and look around.\n"
                        + "Snake: But be careful!");
                break;
            case 3:
                game.out.writeS("Stone: That is so interesting ^-^");
                break;
            default:
                break;
        }
    }

    private void six() {
        Random rn = new Random();
        rn.setSeed(new Date().getTime());
        game.out.writeS("You look around.");
        game.out.writeSlow(". . .", 500);
        int answer = (int) (rn.nextDouble() * 10);
        if (answer < 4) {
            if (game.setStage(new FightStage(new Wolf())) == 1) {
                player.kill(2);
                player.setPosition(505);
            } else {
                player.setPosition(5);
            }
        } else if (answer < 9 && answer >= 4) {
            if (game.setStage(new FightStage(new Tiger())) == 1) {
                player.setPosition(505);
                player.kill(3);
            } else {
                player.setPosition(5);
            }
        } else if (answer == 9) {
            int resFlowey = game.setStage(new FightStage(new Flowey()));
            if (resFlowey == 2) {
                player.setPosition(508);
            } else if (resFlowey == 1) {
                player.setPosition(507);
            } else if (resFlowey == 0) {
                player.setPosition(8);
            }
        }
    }

    private void seven() {
        game.out.writeS("You go the way back.\n"
                + "You don't know exactly what you will do, but this was to crazy for you\n"
                + "You see a flower at the ground.\n");
        int resFlowey = game.setStage(new FightStage(new Flowey()));
        if (resFlowey == 2) {
            player.setPosition(508);
        } else if (resFlowey == 1) {
            player.setPosition(507);
        } else if (resFlowey == 0) {
            player.setPosition(8);
        }
    }

    private void eight() {
        game.out.writeS("Why does the flower know me...\n");
        game.out.writeS("I think is should leave the forest.\n"
                + "I am scared.\n");
        player.setPosition(100);
    }

    private void gtwo() {
        game.out.writeS("Such an idiot.\n"
                + "After all i got, i know how to punish someone...\n\n"
                + "You go around and see a snake.\n");
        player.setPosition(503);
    }

    private void gthree() {
        if (game.setStage(new FightStage(new Snake())) == 1) {
            player.kill(1);
            player.setPosition(504);
        } else {
            player.setPosition(4);
        }
    }

    private void gfour() {
        game.out.writeS("You have fun doing this.");
        player.setPosition(505);
    }

    private void gfive() {
        List<String> options = Arrays.asList("Look around for your next victim", "Search for an Exit", "Eat a pice of the Snake");
        int answer = game.in.getInputWithOptionsV(options, "What do you wanna do?");
        switch (answer) {
            case 0:
                player.setPosition(506);
                break;
            case 1:
                game.out.writeS("You decided to leave this forest.\n"
                        + "But you feel like somebody is following you.\n"
                        + "You see a Flower\n");
                int resFlowey = game.setStage(new FightStage(new Flowey()));
                if (resFlowey == 2) {
                    player.setPosition(508);
                } else if (resFlowey == 1) {
                    player.setPosition(507);
                } else if (resFlowey == 0) {
                    player.setPosition(8);
                }
                break;
            case 2:
                game.out.writeS("You recovered you hp");
                player.setChp(player.getHp());
                break;
            default:
                break;
        }
    }

    private void gsix() {
        Random rn = new Random();
        rn.setSeed(new Date().getTime());
        game.out.writeS("You look around.");
        game.out.writeSlow(". . .", 500);
        int answer = (int) (rn.nextDouble() * 10);
        if (answer < 4) {
            if (game.setStage(new FightStage(new Wolf())) == 1) {
                player.kill(2);
                player.setPosition(505);
            } else {
                player.setPosition(505);
            }
        } else if (answer < 9 && answer >= 4) {
            if (game.setStage(new FightStage(new Tiger())) == 1) {
                player.setPosition(505);
                player.kill(3);
            } else {
                player.setPosition(505);
            }
        } else if (answer == 9) {
            int resFlowey = game.setStage(new FightStage(new Flowey()));
            if (resFlowey == 2) {
                player.setPosition(508);
            } else if (resFlowey == 1) {
                player.setPosition(507);
            } else if (resFlowey == 0) {
                player.setPosition(8);
            }
        }
    }

    private void gseven() {
        game.out.writeS("What does the flower think who i am?\n"
                + "Now it's my time to rule this world.\n"
                + "*Laugh Laugh*\n");
        game.out.writelnSlow("I will control everything.", 125);
        player.kill(4);
        game.out.writeS("You and Flowey are leaving the forest");
        player.setPosition(509);
    }

    private void geight() {
        game.out.writeS("Flowey: We will fusion.\n"
                + "Flowey: We will be the strongest monster on earth\n"
                + "Flowey: Nobody will be able to beat us.\n\n");
        game.out.writeS("You feel roots climbing your leg up.\n"
                + "You consist now of FLOWEY.");
        player.setName("Fl" + player.getName().toUpperCase());
        for (int i = 0; i < 10; i++) {
            player.addExp(new Flowey());
        }
        if (player.isLevelUp()) {
            game.out.writeS(player.getName() + " reached lv" + player.getLv() + ".");
        }
        player.setConsistsFlowey(true);
        player.setPosition(509);
    }

    private void gnine() {
        if (player.isConsistsFlowey()) {
            game.out.writeS("You and Flowey are leaving the forest.");
            player.setPosition(600);
        } else {
            game.out.writeS("You are leaving the forest now.");
            player.setPosition(600);
        }
    }

}
