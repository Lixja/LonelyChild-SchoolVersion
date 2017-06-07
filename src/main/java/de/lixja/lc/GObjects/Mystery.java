package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Mystery extends GObject {

    public Mystery() {
        super("Mystery", 100, 10, 10, 5, 9);
        startSentence = "Ehmm, you don't know what is infront of you.";
        dieSentence = "R28gaG9tZSBhbmQgZGllLg";
        neutralSentence = "Find your way home!";
        sentences.add("???");
        fightOptions.add(new FightOption("???", 3));
        fightOptions.add(new FightOption("???", 3));
        fightOptions.add(new FightOption("???", 3));
    }

}
