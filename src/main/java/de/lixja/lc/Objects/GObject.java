package de.lixja.lc.Objects;

import java.util.LinkedList;

public class GObject {

    private String name;
    private int hp;
    private int def;
    private int atk;
    private int lv;
    private int exp;
    protected LinkedList<String> sentences;
    protected String startSentence;
    protected String dieSentence;
    protected String neutralSentence;

    public GObject(String name, int hp, int def, int atk, int lv) {
        this.name = name;
        this.hp = hp;
        this.def = def;
        this.atk = atk;
        this.lv = lv;
        this.exp = 0;
        sentences = new LinkedList<>();
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
