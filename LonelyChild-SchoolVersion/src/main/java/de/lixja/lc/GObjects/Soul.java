package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Soul extends GObject {

    public Soul() {
        super("Soul", 5, 15, 10, 9, 100);
        startSentence = "Wow, i am really going crazy.";
        dieSentence = "The soul transforms into a deamon.";
        neutralSentence = "The soul finds home.";
        sentences.add("hi?");
        sentences.add("i am peter");
        sentences.add("i was killed");
        sentences.add("it was awful");
        sentences.add("i can't rest");
        sentences.add("i couldn't talk about that with somebody");
        sentences.add("until now");
        sentences.add("you seem friendly enough ^^");
        sentences.add("thank you\ngood bye\n*smiles*");
        fightOptions.add(new FightOption("listen", 10));

    }

}
