package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Tiger extends GObject {

    public Tiger() {
        super("Tiger", 12, 1, 3, 4, 10);
        startSentence = "Look there is a cat. Oh it's an tiger\n"
                + "Look at this tiger!";
        dieSentence = "When i was young i wanted to have a cat.";
        neutralSentence = "The cat like you.";
        sentences.add("*She looks dangerous*");
        fightOptions.add(new FightOption("Mercy", 1));
        fightOptions.add(new FightOption("Feed", 10));
    }
}
