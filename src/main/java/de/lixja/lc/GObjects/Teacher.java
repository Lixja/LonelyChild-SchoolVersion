package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Teacher extends GObject {

    public Teacher() {
        super("Teacher", 75, 25, 45, 12, 25);
        startSentence = "The next idiot.";
        dieSentence = "LU....";
        neutralSentence = "*SCREAMS* LU...";
        sentences.add("I will teach you how to respect me.");
        fightOptions.add(new FightOption("Teach him", 5));
        fightOptions.add(new FightOption("Talk", 10));
    }

}
