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
            int answer = 0;
            boolean choice = false;
            Random rn = new Random();
            rn.setSeed(new Date().getTime());

            switch (player.getPosition()) {

                case 0:
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
                    break;
                case 1:
                    if (game.setStage(new FightStage(new MasterStone())) == 1) {
                        player.kill(0);
                        player.setPosition(502);
                    } else {
                        player.setPosition(2);
                    }
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
                    if (game.setStage(new FightStage(new Snake())) == 1) {
                        player.kill(1);
                        game.out.writeS("Stone: Why did you do that?");
                        choice = game.in.getInputWithQuestionYesNo("Do you wanna fight Stone?");
                        if (choice) {
                            if (game.setStage(new FightStage(new MasterStone())) == 1) {
                                player.kill(0);
                                player.setPosition(504);
                                break;
                            } else {
                                game.out.writeS("Stone flew.\n");
                            }
                            game.out.writeS("Stone flew.\n");
                        }
                        player.setPosition(504);
                    } else {
                        player.setPosition(4);
                    }
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
                    break;
                case 5:
                    if (player.getKilled(0)) {  //Check if Stone is already killed.
                        options = Arrays.asList("Look around.", "Search an exit", "Talk with the Snake");

                    } else {
                        options = Arrays.asList("Look around.", "Search an exit", "Talk with the Snake", "Talk with the Stone");

                    }
                    answer = game.in.getInputWithOptionsV(options, "What do you wanna do?");
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
                    break;
                case 6:
                    game.out.writeS("You look around.");
                    game.out.writeSlow(". . .", 500);
                    answer = (int) (rn.nextDouble() * 3);
                    switch (answer) {
                        case 0:
                            if (game.setStage(new FightStage(new Flowey())) == 1) {
                                player.setPosition(507);
                            } else {
                                player.setPosition(8);
                            }
                            break;
                        case 1:
                            if (game.setStage(new FightStage(new Tiger())) == 1) {
                                player.setPosition(5);
                                player.kill(4);
                            } else {
                                player.setPosition(5);
                            }
                            break;
                        case 2:
                            if (game.setStage(new FightStage(new Wolf())) == 1) {
                                player.kill(3);
                                player.setPosition(5);
                            } else {
                                player.setPosition(5);
                            }
                            break;
                    }
                    break;
                case 7:
                    game.out.writeS("You go the way back.\n"
                            + "You don't know exactly what you will do, but this was to crazy for you\n"
                            + "You see a flower at the ground.\n");
                    if (game.setStage(new FightStage(new Flowey())) == 1) {
                        player.setPosition(508);
                    } else {
                        player.setPosition(8);
                    }
                    break;
                case 8:
                    game.out.writeS("Why does the flower know me...\n");
                    break;

                case 502:
                    game.out.writeS("Such an idiot.\n"
                            + "After all i got, i know how to punish someone...\n\n"
                            + "You go around and see a snake.\n");
                    player.setPosition(503);
                    break;
                case 503:
                    if (game.setStage(new FightStage(new Snake())) == 1) {
                        player.kill(1);
                        player.setPosition(504);
                    } else {
                        player.setPosition(4);
                    }
                    break;
                case 504:
                    game.out.writeS("You have fun doing this.");
                    player.setPosition(505);
                    break;
                case 505:
                    options = Arrays.asList("Look around for your next victim", "Eat a pice of the Snake");
                    answer = game.in.getInputWithOptionsV(options, "What do you wanna do?");
                    switch (answer) {
                        case 0:
                            player.setPosition(506);
                            break;
                        case 1:
                            game.out.writeS("You recovered you hp");
                            player.setChp(player.getHp());
                            break;
                        default:
                            break;
                    }
                    break;
                case 506:
                    game.out.writeS("You look around.");
                    game.out.writeSlow(". . .", 500);
                    answer = (int) (rn.nextDouble() * 3);
                    switch (answer) {
                        case 0:
                            if (game.setStage(new FightStage(new Flowey())) == 1) {
                                player.setPosition(507);
                            } else {
                                player.setPosition(8);
                            }
                            break;
                        case 1:
                            if (game.setStage(new FightStage(new Tiger())) == 1) {
                                player.kill(4);
                                player.setPosition(505);
                            } else {
                                player.setPosition(505);
                            }
                            break;
                        case 2:
                            if (game.setStage(new FightStage(new Wolf())) == 1) {
                                player.kill(3);
                                player.setPosition(505);
                            } else {
                                player.setPosition(505);
                            }
                            break;
                    }
                    break;
                case 507:
                    
                    break;
            }
            game.saveGameData();
        }
    }

}
