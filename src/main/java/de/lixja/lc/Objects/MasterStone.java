package de.lixja.lc.Objects;

public class MasterStone extends GObject {

    public MasterStone() {
        super("MasterStone", 2, 1, 1, 1);
        startSentence = "A friendly Stone don't harm anybody.";
        dieSentence = "Do you know what you just did?...";
        neutralSentence = "The stone seems happy.";
        sentences.add("...");
    }

}
