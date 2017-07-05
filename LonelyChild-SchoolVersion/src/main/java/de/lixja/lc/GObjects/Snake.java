package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Snake extends GObject {

    public Snake() {
        super("Snake", 15, 1, 5, 2, 11);
        startSentence = "A Snake, An angry Snake.";
        dieSentence = "The Snake tries to rest in peace.\n Do you have fun?";
        neutralSentence = "The Snakes apologizes to you.";
        sentences.add("The Snake seems to wanna hurt you!");
        fightOptions.add(new FightOption("Mercy", 1));
        fightOptions.add(new FightOption("Talk", 10));
    }

}
