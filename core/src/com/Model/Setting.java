package com.Model;

import com.badlogic.gdx.Input;

import java.util.ArrayList;

public class Setting {
    private Difficulty difficulty;
    private boolean isMute;
    private boolean isBlackAndWhite;
    private final ArrayList<Integer> up;
    private final ArrayList<Integer> down;
    private final ArrayList<Integer> right;
    private final ArrayList<Integer> left;
    private final ArrayList<Integer> regularBomb;
    private final ArrayList<Integer> radioactiveBomb;
    private final ArrayList<Integer> clusterBomb;
    private final ArrayList<Integer> iceMode;

    public Setting() {
        up = new ArrayList<>();
        up.add(Input.Keys.UP);
        up.add(Input.Keys.W);
        down = new ArrayList<>();
        down.add(Input.Keys.DOWN);
        down.add(Input.Keys.S);
        right = new ArrayList<>();
        right.add(Input.Keys.RIGHT);
        right.add(Input.Keys.D);
        left = new ArrayList<>();
        left.add(Input.Keys.LEFT);
        left.add(Input.Keys.A);
        regularBomb = new ArrayList<>();
        regularBomb.add(Input.Keys.SPACE);
        radioactiveBomb = new ArrayList<>();
        radioactiveBomb.add(Input.Keys.R);
        clusterBomb = new ArrayList<>();
        clusterBomb.add(Input.Keys.C);
        iceMode = new ArrayList<>();
        iceMode.add(Input.Keys.TAB);
        difficulty = Difficulty.easy;
        isMute = false;
        isBlackAndWhite = false;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setMute(boolean mute) {
        isMute = mute;
    }

    public void setBlackAndWhite(boolean blackAndWhite) {
        isBlackAndWhite = blackAndWhite;
    }

    public void setUp(int up) {
        this.up.add(up);
    }

    public void setDown(int down) {
        this.down.add(down);
    }

    public void setRight(int right) {
        this.right.add(right);
    }

    public void setLeft(int left) {
        this.left.add(left);
    }

    public void setRegularBomb(int regularBomb) {
        this.regularBomb.add(regularBomb);
    }

    public void setRadioactiveBomb(int radioactiveBomb) {
        this.radioactiveBomb.add(radioactiveBomb);
    }

    public void setClusterBomb(int clusterBomb) {
        this.clusterBomb.add(clusterBomb);
    }

    public void setIceMode(int iceMode) {
        this.iceMode.add(iceMode);
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public boolean getMute() {
        return isMute;
    }

    public boolean getBlackAndWhite() {
        return isBlackAndWhite;
    }

    public ArrayList<Integer> getUp() {
        return up;
    }

    public ArrayList<Integer> getDown() {
        return down;
    }

    public ArrayList<Integer> getRight() {
        return right;
    }

    public ArrayList<Integer> getLeft() {
        return left;
    }

    public ArrayList<Integer> getRegularBomb() {
        return regularBomb;
    }

    public ArrayList<Integer> getRadioactiveBomb() {
        return radioactiveBomb;
    }

    public ArrayList<Integer> getClusterBomb() {
        return clusterBomb;
    }

    public ArrayList<Integer> getIceMode() {
        return iceMode;
    }
}