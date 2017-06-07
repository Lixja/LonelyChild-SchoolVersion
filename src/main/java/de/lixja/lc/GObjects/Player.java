package de.lixja.lc.GObjects;

import java.util.LinkedList;

public class Player extends GObject {

    private int position;
    private boolean[] killedEnemies = new boolean[21];
    private boolean consistsFlowey;

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
    
    public void kill(int pos){
        killedEnemies[pos] = true;
    }
    
    public boolean getKilled(int pos){
        return killedEnemies[pos];
    }

    public boolean isConsistsFlowey() {
        return consistsFlowey;
    }

    public void setConsistsFlowey(boolean consistsFlowey) {
        this.consistsFlowey = consistsFlowey;
    }
    

}
