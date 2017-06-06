package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class MasterStone extends GObject {

    public MasterStone() {
        super("MasterStone", 2, 1, 0, 1, 1);
        startSentence = "A friendly Stone doesn't harm anybody.";
        dieSentence = "Do you know what you just did?...";
        neutralSentence = "The stone seems happy.";
        sentences.add("...");
        fightOptions.add(new FightOption("MERCY", 1));
    }

}
