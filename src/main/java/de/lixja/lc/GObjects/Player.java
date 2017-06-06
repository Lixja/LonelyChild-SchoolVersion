package de.lixja.lc.GObjects;

public class Player extends GObject {

    private int position;

    public Player(String name) {
        super(name, 20, 5, 5, 1, 1);
        position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
