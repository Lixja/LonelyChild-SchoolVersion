package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Sister extends GObject {

    public Sister(boolean monster) {
        super("Sister", 100, 10, 30, 15, 30);
        startSentence = "Sister: You are not my Brother!";
        dieSentence = "I hate you.";
        neutralSentence = "ehm... i.. i am sorry.";
        sentences.add("Sister: Small little child.");
        sentences.add("Sister: Couldn't my mother stop after our brother.");
        sentences.add("Sister: Everybody hates you.");
        sentences.add("Sister: I hate you.");
        sentences.add("Sister: GO!");
        fightOptions.add(new FightOption("Mercy", 1));
        fightOptions.add(new FightOption("Talk", 5));
        fightOptions.add(new FightOption("Forgive", 7));
        if (monster) {
            this.setChp(0);
        }
    }

}
