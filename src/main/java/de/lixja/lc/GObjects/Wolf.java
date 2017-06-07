package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Wolf extends GObject {

    public Wolf() {
        super("Wolf", 10, 2, 4, 3, 5);
        startSentence = "A Wolf, he looks cute and hungry.";
        dieSentence = "He looks still cute, even if you see his intestines.";
        neutralSentence = "He still wants to be pet.";
        sentences.add("*heckle*");
        fightOptions.add(new FightOption("Mercy", 1));
        fightOptions.add(new FightOption("Pet", 10));
        fightOptions.add(new FightOption("Growl", -2));
    }

}
