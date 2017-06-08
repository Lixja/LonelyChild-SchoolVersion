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
            shutdown();
        }
    }

    public void meetL() {

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
        Thread crash = new Thread(new World());
        crash.start();
    }

}
