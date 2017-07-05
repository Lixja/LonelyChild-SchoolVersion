package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Father extends GObject {

    public Father(boolean monster) {
        super("Father", 150, 50, 50, 16, 30);
        startSentence = "Father: I am disapointed from you.";
        dieSentence = "I am still disapointed from you.";
        neutralSentence = "My son.";
        sentences.add("Father: Why did i have to bang your mother without the condom.");
        sentences.add("Father: You can't understand how much i hate you.");
        sentences.add("Father: I will never love you");
        sentences.add("Brother: go away.");
        fightOptions.add(new FightOption("Mercy", 1));
        fightOptions.add(new FightOption("Talk", 5));
        fightOptions.add(new FightOption("Forgive", 7));
        fightOptions.add(new FightOption("remember i am you child", 8));
        if(monster){ 
            this.setChp(0);
        }
    }

}
