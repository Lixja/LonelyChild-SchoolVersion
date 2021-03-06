package de.lixja.lc.GObjects;

public class Player extends GObject {

    private int position;
    private boolean[] killedEnemies = new boolean[21];
    private boolean consistsFlowey;
    private boolean savedSoul;
    private boolean talkToDeadStone;
    private boolean hitTheDoor;

    public Player(String name) {
        super(name, 10, 2, 3, 1, 1);
        position = 0;
    }

    public Player(Player pl) {
        super(pl.getName(), pl.getHp() * 10, pl.getDef() * 10, pl.getAtk() * 10, pl.getLv() * 10, 1);
        dieSentence = "Even if you hacked the game.\nYou will have the same fate.";
        startSentence = "I am Lucy.\n"
                + "Also know as " + pl.getName();
        sentences.add("I will show you pain.");
        sentences.add("I will show you yourself.");
        sentences.add("I will show what you did.");
        sentences.add("You feel scared.");
        sentences.add("You realised you will die.");
    }

    @Override
    public String nextSentence() {
        this.setAtk(this.getAtk() * 10);
        this.setDef(this.getDef() * 10);
        if (positionOfSentences < sentences.size()) {
            positionOfSentences++;
            return sentences.get(positionOfSentences - 1);
        }
        return sentences.get(positionOfSentences - 1);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void kill(int pos) {
        killedEnemies[pos] = true;
    }

    public boolean getKilled(int pos) {
        return killedEnemies[pos];
    }

    public boolean isConsistsFlowey() {
        return consistsFlowey;
    }

    public void setConsistsFlowey(boolean consistsFlowey) {
        this.consistsFlowey = consistsFlowey;
    }

    public boolean isSavedSoul() {
        return savedSoul;
    }

    public void setSavedSoul(boolean savedSoul) {
        this.savedSoul = savedSoul;
    }

    public boolean isTalkToDeadStone() {
        return talkToDeadStone;
    }

    public void setTalkToDeadStone(boolean talkToDeadStone) {
        this.talkToDeadStone = talkToDeadStone;
    }

    public boolean isHitTheDoor() {
        return hitTheDoor;
    }

    public void setHitTheDoor(boolean hitTheDoor) {
        this.hitTheDoor = hitTheDoor;
    }

}
