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
        sentences.add("nobody listened to me");
        sentences.add("but you do");
        sentences.add("thank you");
        sentences.add("*crys*");
        sentences.add("that means so much for me.");
        sentences.add("good bye\n*smiles*");
        fightOptions.add(new FightOption("listen", 10));

    }

}
