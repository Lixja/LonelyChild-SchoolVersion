package de.lixja.lc.GObjects;

import de.lixja.lc.GObjects.obj.FightOption;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class GObject {

    private String name;
    private int hp;
    private int chp;
    private int def;
    private int atk;
    private int lv;
    private int exp;
    private int neededhelp;
    protected LinkedList<String> sentences;
    protected int positionOfSentences;
    protected LinkedList<FightOption> fightOptions;
    protected String startSentence;
    protected String dieSentence;
    protected String neutralSentence;

    public GObject(String name, int hp, int def, int atk, int lv, int neededhelp) {
        this.name = name;
        this.hp = hp;
        this.chp = hp;
        this.def = def;
        this.atk = atk;
        this.lv = lv;
        this.neededhelp = neededhelp;
        this.exp = 0;
        sentences = new LinkedList<>();
        positionOfSentences = 0;
        fightOptions = new LinkedList<>();
    }
    
    public int damage(int atk){
        int damage = atk/def;
        chp -= damage;
        return damage;
    }
    
    public int addExp(GObject obj){
        int toAddExp = obj.lv * obj.hp;
        exp += toAddExp;
        return toAddExp;
    }
    
    public boolean isLevelUp(){
        if(exp > (lv * atk)){
            Random rn = new Random();
            rn.setSeed(new Date().getTime());
            lv++;
            hp += (int) (rn.nextDouble() * lv) +1;
            chp = hp;
            atk += (int) (rn.nextDouble() * lv) +1;
            def += (int) (rn.nextDouble() * lv)+1;
            exp -= (lv * atk);
            isLevelUp();
            return true;
        }
        return false;
    }
    
    public void help(int v){
        neededhelp -= fightOptions.get(v).getHelpValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getChp() {
        return chp;
    }

    public void setChp(int chp) {
        this.chp = chp;
    }
    
    public boolean isDead(){
        if(chp <= 0){
            return true;
        }
        return false;
    }
    
    public boolean isHelped(){
        if(neededhelp <= 0){
            return true;
        }
        return false;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public LinkedList<String> getSentences() {
        return sentences;
    }

    public void setSentences(LinkedList<String> sentences) {
        this.sentences = sentences;
    }

    public int getNeededhelp() {
        return neededhelp;
    }

    public void setNeededhelp(int neededhelp) {
        this.neededhelp = neededhelp;
    }

    public String nextSentence() {
        if(positionOfSentences < sentences.size()){
            positionOfSentences++;
            return sentences.get(positionOfSentences-1);
        }
        return sentences.get(positionOfSentences-1);
    }  
    

    public LinkedList<FightOption> getFightOptions() {
        return fightOptions;
    }
    
    public LinkedList<String> getFightOptionsAsString() {
        LinkedList<String> foptions = new LinkedList<>();
        for(FightOption f : fightOptions){
            foptions.add(f.getOption());
        }
        return foptions;
    }

    public void setFightOptions(LinkedList<FightOption> FightOptions) {
        this.fightOptions = FightOptions;
    }
    

    public String getStartSentence() {
        return startSentence;
    }

    public void setStartSentence(String startSentence) {
        this.startSentence = startSentence;
    }

    public String getDieSentence() {
        return dieSentence;
    }

    public void setDieSentence(String dieSentence) {
        this.dieSentence = dieSentence;
    }

    public String getNeutralSentence() {
        return neutralSentence;
    }

    public void setNeutralSentence(String neutralSentence) {
        this.neutralSentence = neutralSentence;
    }

}
