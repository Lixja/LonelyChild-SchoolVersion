package de.lixja.lc.GObjects;

public class World extends GObject implements Runnable {

    public World() {
        super("World", 500, 100, 150, 18, 1);
        dieSentence = "THVjeQ: You did such a big mistake.\n"
                + "THVjeQ: Now suffer.\n";
        neutralSentence = "";
        startSentence = "Are you sure it's a great idea to destroy the world?\n"
                + "I mean you live there.\n"
                + "P.s. and this pc is also there.\n";
        sentences.add("Do you really think you can destroy me that easily?");
        sentences.add("You know there are consequences, am I right?");
        sentences.add("What would you do if ... L.Lucy would appear?");
        sentences.add("I a planet.\n");
        sentences.add("You are a demon.");
        sentences.add("...");
    }

    @Override
    public void run() {
        Thread t1 = new Thread(new World());
        t1.start();
        long a = 1;
        while (true) {
            a++;
            if(a>666){
                a = -666;
            }
        }
    }

}
