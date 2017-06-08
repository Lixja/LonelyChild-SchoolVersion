package de.lixja.lc.GObjects;

import java.util.LinkedList;

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
