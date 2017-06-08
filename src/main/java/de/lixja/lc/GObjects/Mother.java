package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Mother extends GObject {

    public Mother(boolean monster) {
        super("Mother", 150, 50, 60, 17, 30);
        startSentence = "You.";
        dieSentence = "I did never love you.";
        neutralSentence = "I love you.\nI am so sorry that i was such a bad mother.\n";
        sentences.add("Mother: Why do you have to be my son.");
        sentences.add("Mother: Why can't you be like your brother or sister.");
        sentences.add("Mother: You are the dead for us.");
        sentences.add("Mother: Hurry Up and GO AWAY!");
        sentences.add("Brother: GO!");
        fightOptions.add(new FightOption("Mercy", 1));
        fightOptions.add(new FightOption("Talk", 5));
        fightOptions.add(new FightOption("Forgive", 7));
        fightOptions.add(new FightOption("Say MOM", 8));
        if(monster){ 
            this.setChp(0);
        }
    }

}
