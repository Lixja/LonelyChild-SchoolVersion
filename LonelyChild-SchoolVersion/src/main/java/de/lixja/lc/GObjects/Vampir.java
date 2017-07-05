package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Vampir extends GObject {

    public Vampir() {
        super("Vampir", 50, 1, 10, 7, 15);
        startSentence = "Not a human.\nOh it's a vampir.";
        dieSentence = "*Scream and decays into ash.";
        neutralSentence = "Vampir: You was delicious.";
        sentences.add("I love human blood.");
        sentences.add("I would do anything for blood.");
        fightOptions.add(new FightOption("Spend Blood", 15));
    }

}
