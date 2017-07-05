package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Principal extends GObject {

    public Principal() {
        super("Principal", 100, 25, 50, 13, 25);
        startSentence = "The last idiot from this place.";
        dieSentence = "no..NO.NOOOOOOO";
        neutralSentence = "*SCREAMS*";
        sentences.add("You will get suspended.");
        fightOptions.add(new FightOption("Show respect", 5));
        fightOptions.add(new FightOption("Talk", 5));
    }

}
