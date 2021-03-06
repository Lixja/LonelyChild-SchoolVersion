package de.lixja.lc.Stage;

import de.lixja.lc.GObjects.GObject;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
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
                    if (enemy.getFightOptionsAsString().size() == 0) {
                        game.out.writeS("There is no mercy.");
                        break;
                    }
                    int i = game.in.getInputWithOptionsH(enemy.getFightOptionsAsString(), "Choice");
                    enemy.help(i);
                    break;
            }
            if (!enemy.isDead() && !enemy.isHelped()) {
                if (!attackBlocked()) {
                    game.out.writeln(enemy.getName() + " attacked you!\nYou got " + player.damage(enemy.getAtk()) + " damage.");
                }
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
        }
        game.out.writeWall();
        if (enemy.isHelped() && !enemy.isDead()) {
            enemyState = 0;
        } else if (!enemy.isHelped() && enemy.isDead()) {
            enemyState = 1;
        } else if (enemy.isHelped() && enemy.isDead()) {
            enemyState = 2;
        } else if (player.isDead()) {
            if (enemy.getName() != player.getName()) {
                game.out.writeS("Y0u D1eD");
                System.exit(0);
            }
        }
    }

    private boolean attackBlocked() {
        game.out.writeS("Block the attack.");
        List<String> options = Arrays.asList("Stone", "Scissor", "Paper");
        int choice = game.in.getInputWithOptionsH(options, "What will you choose?");
        Random rn = new Random();
        rn.setSeed(new Date().getTime());
        int cchoice = rn.nextInt(3);
        game.out.writeS(enemy.getName() + " selected " + options.get(cchoice) + ".");
        if (choice == cchoice) {
            game.out.writeS("Draw");
            return attackBlocked();
        } else if (choice == cchoice - 1) {
            game.out.writeS("You Won");
            return true;
        } else if (choice == 2 && cchoice == 0) {
            game.out.writeS("You Won");
            return true;
        } else {
            game.out.writeS("You Lost");
            return false;
        }
    }

    @Override
    public int happened() {
        return enemyState;
    }

    public void printStats(GObject go) {
        game.out.writeln(go.getName() + ": " + "HP: " + go.getHp() + "/" + go.getChp() + " ATK: " + go.getAtk() + " DEF: " + go.getDef());
    }

}
