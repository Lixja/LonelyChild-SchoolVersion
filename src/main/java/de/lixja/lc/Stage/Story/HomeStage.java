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

import de.lixja.lc.GObjects.Brother;
import de.lixja.lc.GObjects.Father;
import de.lixja.lc.GObjects.Mother;
import de.lixja.lc.GObjects.Player;
import de.lixja.lc.GObjects.Principal;
import de.lixja.lc.GObjects.Pupil;
import de.lixja.lc.GObjects.Sister;
import de.lixja.lc.GObjects.Teacher;
import de.lixja.lc.Stage.FightStage;
import de.lixja.lc.Stage.Stage;

/**
 *
 * @author Dimitrios Diamantidis &lt;Dimitri.dia@ledimi.com&gt;
 */
public class HomeStage extends Stage {

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
        while ((player.getPosition() < 300 && player.getPosition() >= 200) || (player.getPosition() >= 700 && player.getPosition() < 800)) {
            switch (player.getPosition()) {
                case 200:
                    zero();
                    break;
                case 201:
                    one();
                    break;
                case 202:
                    two();
                    break;

                case 700:
                    gzero();
                    break;
                case 701:
                    gone();
                    break;
                case 702:
                    gtwo();
                    break;
                case 703:
                    gthree();
                    break;
            }
        }
    }

    private void zero() {
        game.out.writeS("I am back home...\n"
                + "I can't go there.\n"
                + "They hate me.\n"
                + "It will all start from the begining.\n"
                + "Mother: " + player.getName() + "!!!\n"
                + "Mother: You are back...\n");
        game.in.next();
        player.setPosition(1);
    }

    private void one() {
        if (game.setStage(new FightStage(new Mother(false))) == 1) {
            player.kill(16);
            game.out.writeS("You killed you mother... Do you feel better?");
            player.setPosition(202);
        } else {
            game.out.writeS("Mother: ...\n"
                    + "Mother: I am sorry how i used to be.\n"
                    + "Mother: I will change.\n"
                    + "Mother: Let us go to Father.");
            player.setPosition(202);
        }
    }

    private void two() {
        if (player.getKilled(16)) {
            game.out.writeS("You go into your house.\n"
                    + "You see your dad.\n"
                    + "Your dad sees blood you hands.\n"
                    + "Your dad attacks you.\n");
            game.setStage(new FightStage(new Father(true)));
            game.out.writeS("Your siblings saw that and flew.\n"
                    + "You feel great and relax a little bit.\n");
            player.setPosition(12345);

        } else {
            game.out.writeS("You follow your mom.\n"
                    + "She holds your hand.\n"
                    + "She talks now with you Father.\n"
                    + "You Father attacks you.\n");
            if (game.setStage(new FightStage(new Father(false))) == 1) {
                player.getKilled(15);
                game.out.writeS("What did you do?...");
                game.out.writeS("This was your Father!");
                game.out.writeS("Your Mother attacks you.");
                game.setStage(new FightStage(new Mother(true)));
                game.out.writeS("Your siblings saw that and flew.\n"
                        + "You feel great and relax a little bit.\n");
                player.setPosition(12345);
            } else {
                game.out.writeS("Parents: We are so sorry to you...\n"
                        + "Father: I can't understand why i hated you...\n"
                        + "Parents: We will talk with your siblings about that.\n"
                        + "They talk with you siblings\n"
                        + "You and your family are now together");
                player.setPosition(1234);
            }

        }
        System.exit(0);
    }

    private void gzero() {
        game.out.writeS("You reached your home town.\n"
                + "You see some Pupils that bullied you.\n");
        if (player.isConsistsFlowey()) {
            game.out.writeS("Let's kill them.");
        }
        if (game.setStage(new FightStage(new Pupil())) == 1) {
            player.kill(10);
            game.out.writeS("The ground under the dead body disapeared, he fell down\n");
        } else {
            game.out.writeS("The ground under the pupil disapeared, he fell down.\n"
                    + "Now he is dead.\n");
        }
        game.out.writeS("You hear a voice whispers: I am coming back\n");

        game.out.writeS(player.getName() + ": one less");
        player.setPosition(701);
    }

    private void gone() {
        game.out.writeS("The teacher looks at you.\n"
                + "He wants to scream.\n"
                + "You attacked him.\n");
        if (game.setStage(new FightStage(new Teacher())) == 1) {
            player.kill(11);
            game.out.writeS("A raven comes at pick his eye off.\n");
        } else {
            game.out.writeS("A swarm of raven comes and try to eat your teacher.\n"
                    + "Now he is dead.\n");
        }

        game.out.writeS("You hear a voice whispers: I am not far away.\n");

        game.out.writeS(player.getName() + ": one less");
        player.setPosition(702);

    }

    private void gtwo() {
        game.out.writeS("The Principal looks at you.\n"
                + "He comes right at you.\n"
                + "Principal: You little bas.\n"
                + "You attack him.\n");
        if (game.setStage(new FightStage(new Principal())) == 1) {
            player.kill(12);
            game.out.writeS("His body starts to burn.\n");
        } else {
            game.out.writeS("His body catched fire.\nHe screams.\n"
                    + "Now he is dead.\n");
        }

        game.out.writeS("You hear a voice whispers: Go home and let it end\n");

        game.out.writeS(player.getName() + ": one less");
        player.setPosition(703);
    }

    private void gthree() {
        game.out.writeS("You go the way to your \"home\".\n"
                + "When you reached you see you whole family\n"
                + "They want to say something.\n");
        game.setStage(new FightStage(new Brother(true)));
        game.setStage(new FightStage(new Sister(true)));
        game.setStage(new FightStage(new Father(true)));
        game.setStage(new FightStage(new Mother(true)));
        player.kill(13);
        player.kill(14);
        player.kill(15);
        player.kill(16);

        game.out.writeS("You killed them before they said a word:\n\n"
                + "Their body starts to melt.\n"
                + "You feel happy.\n");

        game.out.writeS("You hear a voice whispers: Now i will take you.\n");

        player.setPosition(800);
    }
}
