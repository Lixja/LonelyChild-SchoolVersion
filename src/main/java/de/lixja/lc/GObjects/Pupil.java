package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Pupil extends GObject {

    public Pupil() {
        super("Pupil", 50, 10, 30, 11, 25);
        startSentence = "An idiot. Show him what you can.";
        dieSentence = "*SCREAMS*L.l...";
        neutralSentence = "*SCREAMS*";
        sentences.add("You are back.\nYou are really an idiot.");
        fightOptions.add(new FightOption("Show him strength", 5));
        fightOptions.add(new FightOption("Talk", 5));
    }

}
