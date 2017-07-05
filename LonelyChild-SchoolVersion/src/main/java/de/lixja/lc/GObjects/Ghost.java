package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Ghost extends GObject {

    public Ghost() {
        super("Ghost", 30, 10, 10, 6, 15);
        startSentence = "A Ghost. Buh.";
        dieSentence = "Ghosts can't die ;P\nBut I hate you.";
        neutralSentence = "The ghost finds peace.";
        sentences.add("buuuuh.");
        fightOptions.add(new FightOption("Mercy", 1));
        fightOptions.add(new FightOption("Talk", 6));
        fightOptions.add(new FightOption("Say Buh", 6));
    }

}
