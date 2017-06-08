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
import de.lixja.lc.GObjects.World;
import de.lixja.lc.Stage.FightStage;
import de.lixja.lc.Stage.Stage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.SystemUtils;

/**
 *
 * @author Dimitrios Diamantidis &lt;Dimitri.dia@ledimi.com&gt;
 */
public class WorldStage extends Stage {

    private Player player;

    @Override
    public void start() {
        player = game.getData().getPlayer();

        if (player.getPosition() == 800) {
            destroyWorld();
        } else if (player.getPosition() == 999) {
            meetL();
        }
    }

    public void destroyWorld() {
        game.out.writeSlow("...\n"
                + "So little Child.\n"
                + "Now you have done it.\n"
                + "You killed them all.\n"
                + "So destroy this world and let it end.\n", 150);
        if (player.isConsistsFlowey()) {
            game.out.writeS("Flowey: Finally.");
        } else {
            if (!player.getKilled(4)) {
                game.out.writeS("Flowey: Don't do it.\n"
                        + "Flowey: Please\n\n"
                        + "Flowey got killed\n");
            }
        }
        game.in.next();
        if (game.setStage(new FightStage(new World())) == 1) {
            player.kill(17);
            player.setPosition(999);
            game.saveGameData();
            shutdown();
        }
    }

    public void meetL() {
        game.sleep(3000);
        game.out.writeS("Lucy: ...\n"
                + "Lucy: Hello " + player.getName()
                + "Lucy: Until now i thought i would be the only beeing from hell that could kill Satan.\n"
                + "Lucy: But you are special\n"
                + "Lucy: Therefore."
                + "Lucy: I hate you!");
        game.sleep(1000);
        if (player.getKilled(0)) {
            game.out.writeS("MasterStone: I thought you are friendly");
        }
        if (player.getKilled(1)) {
            game.out.writeS("Snake: I only wanted to protect my people.");
        }
        if (player.getKilled(2)) {
            game.out.writeS("Wolf: I was cute...");
        }
        if (player.getKilled(3)) {
            game.out.writeS("Tiger: I only wanted to find something for my kids.");
        }
        if (player.getKilled(4)) {
            game.out.writeS("Flowey: I know i am bad flower but even i can be so bad.");
        }
        if (player.getKilled(5)) {
            game.out.writeS("Ghost: You could help me.");
        }
        if (player.getKilled(6)) {
            game.out.writeS("Vampir: I hate the sun, but i hate you more.");
        }
        if (player.getKilled(7)) {
            if (player.getKilled(2)) {
                game.out.writeS("Werewolf: You killed my son!");
            } else {
                game.out.writeS("Werewolf: I want to see my son one last time.");
            }
        }
        if (player.getKilled(10)) {
            game.out.writeS("Pupil: I bullied you.\nPupil: But you killed me.");
        }
        if (player.getKilled(11)) {
            game.out.writeS("Teacher: I only wanted to teach you respect.");
        }
        if (player.getKilled(12)) {
            game.out.writeS("Principal: I am sorry but you didn't followed the rules.");
        }
        if (player.getKilled(13)) {
            game.out.writeS("Brother: You hit our Mother.");
        }
        if (player.getKilled(14)) {
            game.out.writeS("Sister: You were so bad at us.");
        }
        if (player.getKilled(15)) {
            game.out.writeS("Father: I only wanted to protect my family.\nFather: I don't know what i did to you.");
        }
        if (player.getKilled(16)) {
            game.out.writeS("Mother: I love you my child.\nMother: But... YOU ARE A MONSTER\nMother: I can never forget what you did.");
        }
        if (player.getKilled(17)) {
            game.out.writeS("World: They weren't the bad people.\nWorld: It was only YOU");
        }

        game.out.writeS("Now you remember.\nYou become more and more crazy\n");
        game.out.writeS("You attack Lucy\n");
        game.out.writeSlow(player.getName() + ": You are lying. Go away. I don't want to hear a word any more\n"
                + player.getName() + ": You are lying LYING LYING LYING LYING.\n"
                + player.getName() + ": I WILL KILL YOU LUCY\n", 10);
        
        game.setStage(new FightStage(new Player(player)));
        game.out.writeS("Lucy: now it's over little child\n"
                + "Lucy: I delete you.\n"
                + "Lucy: Good bye.");

        deleteGame();
        shutdown();
    }

    public void deleteGame() {
        game.getData().setTeachedStory(false);
        game.getData().setPlayer(new Player(""));
        game.saveGameData();
    }

    public void shutdown() {
        try {
            String shutdownCommand = "";
            if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_UNIX || SystemUtils.IS_OS_MAC_OSX) {
                shutdownCommand = "shutdown -h now";
            } else if (SystemUtils.IS_OS_WINDOWS) {
                shutdownCommand = "shutdown.exe -s -t 0";
            } else {

            }
            game.out.write("Exception in thread \"WORLD\" world.life.dieexception\n"
                    + "	at world.life.die(world.java:666)\n"
                    + "	at player.kill.world(player.java:999)\n"
                    + "	at Lucy.controlls.everything(lucy.???:???");
            game.sleep(3000);
            Runtime.getRuntime().exec(shutdownCommand);
        } catch (IOException ex) {
            Logger.getLogger(WorldStage.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        game.sleep(3000);
        Thread crash = new Thread(new World()); //If the pc does not shut down ^-^
        crash.start();
    }

}
