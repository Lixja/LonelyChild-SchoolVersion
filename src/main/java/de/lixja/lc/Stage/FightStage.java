package de.lixja.lc.Stage;

import de.lixja.lc.GObjects.GObject;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class FightStage extends Stage {

    public GObject enemy;
    public int enemyState = 0;
    public LinkedList<String> options;

    public FightStage(GObject enemy) {
        this.enemy = enemy;
        options = new LinkedList<>();
        options.add("FIGHT");
        options.add("ACT");
        options.add("ITEM");
    }

    @Override
    public void start() {
        GObject player = game.getData().getPlayer();
        game.out.writeWall();
        game.out.writeSlow("You will fight against: ", 50);
        game.out.writelnSlow(enemy.getName(), 100);
        game.out.writeWall();
        game.out.writeln(enemy.getStartSentence());
        game.out.writeWall();
        while (!enemy.isDead() && !enemy.isHelped() && !player.isDead()) {
            printStats(enemy);
            printStats(player);
            switch (game.in.getInputWithOptionsH(options, "Choice")) {
                case 0:
                    game.out.writeln("You did " + enemy.damage(player.getAtk()) + " damage to " + enemy.getName() + ".");
                    break;
                case 1:
                    int i = game.in.getInputWithOptionsH(enemy.getFightOptionsAsString(), "Choice");
                    enemy.help(i);
                    break;
                case 2:
                    break;
            }
            if (!enemy.isDead() && !enemy.isHelped() && !attackBlocked(enemy.getLv())) {
                game.out.writeln(enemy.getName() + " attacked you!\nYou got " + player.damage(enemy.getAtk()) + " damage.");
            }else if(!enemy.isDead() && enemy.isHelped()){
                game.out.writeWall();
                game.out.writeS(enemy.nextSentence());
                game.out.writeWall();
            }
        }
        if (enemy.isDead()) {
            game.out.writelnSlow(enemy.getDieSentence(), 50);
            game.out.write("You got " + player.addExp(enemy) + " exp");
            game.out.writelnSlow("...", 50);
            if (player.isLevelUp()) {
                game.out.writeln("You are now level " + player.getLv());
            }
        } else if (enemy.isHelped()) {
            game.out.writeln(enemy.getNeutralSentence());
            player.setHp(player.getChp());
        } else if (player.isDead()) {
            game.setStage(new GameOverStage());
        }
        game.out.writeWall();
        if (enemy.isHelped() && !enemy.isDead()) {
            enemyState = 0;
        } else if (!enemy.isHelped() && enemy.isDead()) {
            enemyState = 1;
        } else if (enemy.isHelped() && enemy.isDead()) {
            enemyState = 2;
        }
    }

    private boolean attackBlocked(int lv) {
        game.out.writeS("Press the button when the X appears.");
        Random rn = new Random();
        rn.setSeed(new Date().getTime());
        for (int i = 0; i < lv; i++) {
            game.sleep(rn.nextInt(2100));
            Date xTime = new Date();
            game.out.write("X");
            game.in.get();
            Date yTime = new Date();
            if (xTime.getTime() + 750 < yTime.getTime()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int happened() {
        return enemyState;
    }

    public void printStats(GObject go) {
        game.out.writeln(go.getName() + ": " + "HP: " + go.getHp() + "/" + go.getChp() + " ATK: " + go.getAtk() + " DEF: " + go.getDef());
    }

}
