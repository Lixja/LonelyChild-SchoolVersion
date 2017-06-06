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
package de.lixja.lc.Stage;

import de.lixja.lc.GObjects.Player;

/**
 *
 * @author Dimitrios Diamantidis &lt;Dimitri.dia@ledimi.com&gt;
 */
public class BootStage extends Stage {

    @Override
    public void start() {
        game.out.writeln("___LonelyChild___");
        if (game.getData().isTeachedStory()) {
            if (game.in.getInputWithQuestionYesNo("Do you want to skip?")) {
                game.setStage(new StoryStage());
                return;
            }
        }
        game.sleep(1000);
        game.out.writelnSlow("Once Upon A Time...\n"
                + "There Was A Little Child On A Rotten World.\n"
                + "This World Was Once A Very Beatiful Place.\n"
                + "But The Human Race Destroyed It.\n", 50);
        game.out.writelnSlow(". . .", 500);

        if (!game.getData().isTeachedStory()) {
            String name = game.in.getInputWithQuestion("What is you name?");
            game.getData().setPlayer(new Player(name));
            game.getData().setTeachedStory(true);
            game.saveGameData();
            game.out.writeln("What a wonderful name.\n"
                    + "Now go and save!");
            game.setStage(new StoryStage());
            return;
        } else {
            game.out.writeln(game.getData().getPlayer().getName() + "!!!");
            game.out.writelnSlow("Go and save!", 100);
            game.setStage(new StoryStage());
        }

    }

}
