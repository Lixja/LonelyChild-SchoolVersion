package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;

public class Flowey extends GObject {

    public Flowey() {
        super("Flowey", 20, 1, 4, 5, 1);
        startSentence = "A Flower?!";
        dieSentence = "L..U..C...Y";
        neutralSentence = "..I will still follow you little guy.";
        sentences.add("I know you.");
        sentences.add("I know you better than you think.");
        sentences.add("I saw how you was tortured");
        sentences.add("I know what you want.");
        sentences.add("Should I help you?");
        fightOptions.add(new FightOption("Mercy", 0));
        fightOptions.add(new FightOption("Talk", 0));
    }

    @Override
    public void help(int i) {
        if (fightOptions.get(0).getOption() == "Accept") {
            if (i == 0) {
                dieSentence = "Great decision partner.";
                setNeededhelp(0);
                setChp(0);
                setAtk(0);
                setLv(0);
            } else if (i == 1) {
                setNeededhelp(0);
            }
        }
    }

    @Override
    public String nextSentence() {
        if (positionOfSentences < sentences.size()) {
            positionOfSentences++;
            if (positionOfSentences == sentences.size()) {
                fightOptions.clear();
                fightOptions.add(new FightOption("Accept", 1));
                fightOptions.add(new FightOption("Decline", 1));
            }
            return sentences.get(positionOfSentences - 1);
        }
        return sentences.get(positionOfSentences - 1);
    }

}
