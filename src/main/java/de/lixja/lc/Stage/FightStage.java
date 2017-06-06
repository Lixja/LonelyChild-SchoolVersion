package de.lixja.lc.Stage;

import de.lixja.lc.GObjects.GObject;
import java.util.LinkedList;

public class FightStage extends Stage {
    
    public GObject enemy;
    
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
        game.out.writeln(enemy.getStartSentence());
        while (!enemy.isDead() && !enemy.isHelped() && !player.isDead()) {
            printStats(enemy);
            printStats(player);
            switch (game.in.getInputWithOptionsH(options, "Choice")) {
                case 0:
                    game.out.writeln("You did " + enemy.damage(player.getAtk()) + " damage to " + enemy.getName()+ ".");
                    break;
                case 1:
                    int i = game.in.getInputWithOptionsH(enemy.getFightOptionsAsString(), "Choice");
                    enemy.help(i);
                    break;
                case 2:
                    break;
            }
            if(!enemy.isDead() && !enemy.isHelped()){
                game.out.writeln(enemy.getName() +" attacked you!\nYou got " + player.damage(enemy.getAtk()) +".");
            }
        }
        if(enemy.isDead()){
            game.out.writelnSlow(enemy.getDieSentence(), 50);
            game.out.write("You got " + player.addExp(enemy)+" exp");
            game.out.writelnSlow("...", 50);
            if(player.isLevelUp()){
                game.out.writeln("You are now level "+ player.getLv());
            }
        }else if(enemy.isHelped()){
            game.out.writeln(enemy.getNeutralSentence());
        }else if(player.isDead()){
            game.setStage(new GameOverStage());
        }
    }
    
    public void printStats(GObject go) {
        game.out.writeln(go.getName() + ": " + "HP: " + go.getHp() + "/" + go.getChp() + " ATK: " + go.getAtk() + " DEF: " + go.getDef());
    }
    
}
