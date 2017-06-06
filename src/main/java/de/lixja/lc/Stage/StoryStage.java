package de.lixja.lc.Stage;

import de.lixja.lc.GObjects.Flowey;
import de.lixja.lc.GObjects.MasterStone;
import de.lixja.lc.GObjects.Player;
import de.lixja.lc.GObjects.Snake;
import de.lixja.lc.GObjects.Tiger;
import de.lixja.lc.GObjects.Wolf;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class StoryStage extends Stage {

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
        Player player = game.getData().getPlayer();
        while (true) {
            List<String> options;
            int choice = 0;
            Random rn = new Random();
            rn.setSeed(new Date().getTime());

            switch (player.getPosition()) {

                case 0:
                    game.out.writeS("You look around.");
                    game.sleep(1500);
                    game.out.writeS("You don't know were you are.\n"
                            + "You can't even remember the way or since when you were in a forest.\n"
                            + "But think know it's a better place.\n");
                    game.out.writelnSlow(". . .", 500);
                    game.out.writeS("You don't want to think, about what they did.\n"
                            + "But you are still so angry!\n"
                            + "You think you will get crazy.\n");
                    game.sleep(500);
                    game.out.writelnSlow("You hear a stone talking?", 120);
                    player.setPosition(1);
                    game.saveGameData();
                    break;
                case 1:
                    if (game.setStage(new FightStage(new MasterStone()))) {
                        player.setPosition(502);
                    } else {
                        player.setPosition(2);
                    }
                    game.saveGameData();
                    break;
                case 2:
                    game.out.writeS("No.\n");
                    game.sleep(500);
                    game.out.writeS("I will not be like them.\n"
                            + "I will be an other person\n"
                            + "Even if they tortered me like that.\n");
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
                    break;
                case 3:
                    if (game.setStage(new FightStage(new Snake()))) {
                        player.setPosition(504);
                    } else {
                        player.setPosition(4);
                    }
                    game.saveGameData();
                    break;
                case 4:
                    game.out.writeS("Snake: ...\n"
                            + "Snake: I am sorry I attacked you.\n"
                            + "Snake: Every human i saw until now was bad.\n"
                            + "Snake: But you seem so different.\n");
                    game.sleep(500);
                    game.out.writeS("Snake: You are welcome to stay at this place.\n"
                            + "Snake: But be careful, most beeings would attack you if they see you.\n"
                            + "Snake: We hate humans. \n\n");
                    player.setPosition(5);
                    game.saveGameData();
                    break;
                case 5:
                    options = Arrays.asList("Look around.", "Search an exit", "Talk with the Stone", "Talk with the Snake");
                    choice = game.in.getInputWithOptionsV(options, "What do you wanna do?");
                    switch (choice) {
                        case 0:
                            player.setPosition(6);
                            break;
                        case 1:
                            player.setPosition(7);
                            break;
                        case 2:
                            game.out.writeS("Stone: That is so interesting ^-^");
                            break;
                        case 3:
                            game.out.writeS("Snake: Go and look around.\n"
                                    + "Snake: But be careful!");
                            break;
                        default:
                            break;
                    }
                    break;
                case 6:
                    game.out.writeS("You look around.");
                    game.out.writeSlow(". . .", 500);
                    choice = (int) (rn.nextDouble() * 3);
                    switch (choice) {
                        case 0:
                            if (game.setStage(new FightStage(new Flowey()))) {
                                player.setPosition(5);
                            } else {
                                player.setPosition(8);
                            }
                            break;
                        case 1:
                            if (game.setStage(new FightStage(new Tiger()))) {
                                player.setPosition(5);
                            } else {
                                player.setPosition(5);
                            }
                            break;
                        case 2:
                            if (game.setStage(new FightStage(new Wolf()))) {
                                player.setPosition(5);
                            } else {
                                player.setPosition(5);
                            }
                            break;
                    }
                    break;

                case 7:
                    break;

                case 502:
                    break;
            }
        }
    }

}
