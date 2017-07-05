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
package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

/**
 *
 * @author Dimitrios Diamantidis &lt;Dimitri.dia@ledimi.com&gt;
 */
public class Werewolf extends GObject{
    
    public Werewolf() {
        super("Werewolf", 50, 10, 1, 8, 15);
        startSentence = "Uhhh, a Werewolf ^-^.";
        dieSentence = "He looks like his father from the forest.";
        neutralSentence = "He looks kind of cute.";
        sentences.add("I am a wolf, what should i say?");
        fightOptions.add(new FightOption("pet", 3));
        fightOptions.add(new FightOption("Pet", 6));
        fightOptions.add(new FightOption("PET", 9));
    }
    
    
    
}
