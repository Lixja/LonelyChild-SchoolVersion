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
                + "This World Was Once A Very Beautiful Place.\n"
                + "But The Human Race Destroyed This Place.\n"
                + "After Many Years A Child Was Born.\n"
                + "And The Humans Selected This Child To Be Their Next Victim.\n"
                + "The Story Of This Soul Is A Sad One.\n\n", 75);
        game.out.writelnSlow(". . .", 400);
        game.out.writeSlow("Every Human Bothered Him.\n"
                + "His Family Beat Him.\n"
                + "His \"Friends\" Bullied Him.\n"
                + "His Teacher Shouted At Him.\n"
                + "Even People He Did Not Knew Offended Him.\n\n"
                + "There Wasn't A Reason For Turtiring Him.\n"
                + "But Everybody Did It.\n"
                + "And He Could Not Understand Why Him."
                + "So He Run Away.\n",75);
        game.out.writeSlow("Far Far Away\n\n", 125);

        if (!game.getData().isTeachedStory()) {
            String name = selectName();
            game.getData().setPlayer(new Player(name));
            game.getData().setTeachedStory(true);
            game.saveGameData();
            game.out.writeln("Right.\n"
                    + "Now go and save your soul!");
            game.setStage(new StoryStage());
            return;
        } else {
            game.out.writeln(game.getData().getPlayer().getName() + "!!!");
            game.out.writelnSlow("Go and save yourself!", 100);
            game.setStage(new StoryStage());
        }

    }
    
    private String selectName(){
        String name = game.in.getInputWithQuestion("What was his name?");
        switch(name.toLowerCase()){
            case "lucy":
                game.out.writelnSlow("This Name...", 250);
                game.out.writelnSlow("HOW DO YOU KNOW THE NAME OF HELL!!!\n",25);
                System.exit(0);
                break;
            case "flowey":
                game.out.writeS("That is a flower not a name.");
                name = selectName();
                break;
            case "fuck":
                game.out.writeS("That is an insult not a name.");
                name = selectName();
                break;
            case "josef":
                game.out.writeS("That is the creators name not a name. ;P");
                name = selectName();
                break;
            case "lonelychild":
                game.out.writeS("Come on.\nBe creative.");
                name = selectName();
                break;
            case "child":
                game.out.writeS("Come on.\nBe creative.");
                name = selectName();
                break;
            case "teacher":
                boolean answer = game.in.getInputWithQuestionYesNo("Are you a teacher?");
                if(answer){
                    game.out.writeS("Be more creative.");
                }else{
                    game.out.writeS("Show the teacher that you can be more creative than him.");
                }
                name = selectName();
                break;
            case "MasterStone":
                game.out.writeS("YOU ARE NOT AN INNOCENT SOUL.");
                name = selectName();
                break;
        }
        return name;
    }

}
