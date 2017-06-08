package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Brother extends GObject {

    public Brother(boolean monster) {
        super("Brother", 100, 30, 50, 14, 30);
        startSentence = "Brother: You are not my Brother!";
        dieSentence = "I hate you.";
        neutralSentence = "ehm... i.. i am sorry.";
        sentences.add("Brother: Small little child.");
        sentences.add("Brother: Couldn't my mother stop after me.");
        sentences.add("Brother: Everybody hates you.");
        sentences.add("Brother: Why did you came back?");
        sentences.add("Brother: GO!");
        fightOptions.add(new FightOption("Mercy", 1));
        fightOptions.add(new FightOption("Talk", 5));
        fightOptions.add(new FightOption("Forgive", 7));
        if(monster){ 
            this.setChp(0);
        }
    }

}
