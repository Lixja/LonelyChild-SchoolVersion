package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

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
/**
 *
 * @author Dimitrios Diamantidis &lt;Dimitri.dia@ledimi.com&gt;
 */
public class Deamon extends GObject {

    public Deamon() {
        super("Deamon", 99, 30, 50, 10, 2);
        startSentence = "You know you did a big mistake.";
        dieSentence = "What are you...?\n"
                + "You killed me\n"
                + "I..I.. am sorry\n";
        neutralSentence = "There is no neutral ending for this fight.";
        sentences.add("I will kill you.");
        sentences.add("I will let you feel empty.");
        sentences.add("You think it is just so simple to kill me!");
        sentences.add("Feel my pain.");
        fightOptions.add(new FightOption("DIE", 1));

    }

    @Override
    public boolean isDead() {
        if (this.getNeededhelp() == 2) {
            if (this.getChp() <= 0) {
                this.setChp(66);
                sentences.add("Soul recovered hp from determination to kill you.");
                sentences.add("I have to stay and kill you.");
            }
        } else {
            if (this.getChp() <= 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public void help(int v) {
        this.setAtk(this.getAtk()+v);
    }

}
