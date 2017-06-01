package de.lixja.lc.Objects;

public class Snake extends GObject {

    public Snake() {
        super("Snake", 30, 1, 15, 3);
        startSentence = "A Snake, You don't think that he wants to attack you.";
        dieSentence = "The Snake tries to rest in peace.\n Do you have fun?";
        neutralSentence = "The Snakes thanks you.";
        sentences.add("The Snake seems to wanna hurt you!");
    }

}
