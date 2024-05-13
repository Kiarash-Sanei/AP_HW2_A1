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
    private final ArrayList<Integer> clockWise;
    private final ArrayList<Integer> counterClockWise;
    private final ArrayList<Integer> regularBomb;
    private final ArrayList<Integer> radioactiveBomb;
    private final ArrayList<Integer> clusterBomb;
    private final ArrayList<Integer> iceMode;
    private final ArrayList<Integer> nextWave;
    private final ArrayList<Integer> radioactiveBombIncrease;
    private final ArrayList<Integer> clusterBombIncrease;
    private final ArrayList<Integer> tankIncrease;
    private final ArrayList<Integer> revive;

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
        clockWise = new ArrayList<>();
        clockWise.add(Input.Keys.NUMPAD_8);
        clockWise.add(Input.Keys.NUMPAD_6);
        counterClockWise = new ArrayList<>();
        counterClockWise.add(Input.Keys.NUMPAD_2);
        counterClockWise.add(Input.Keys.NUMPAD_4);
        regularBomb = new ArrayList<>();
        regularBomb.add(Input.Keys.SPACE);
        radioactiveBomb = new ArrayList<>();
        radioactiveBomb.add(Input.Keys.R);
        clusterBomb = new ArrayList<>();
        clusterBomb.add(Input.Keys.C);
        iceMode = new ArrayList<>();
        iceMode.add(Input.Keys.TAB);
        nextWave = new ArrayList<>();
        nextWave.add(Input.Keys.P);
        radioactiveBombIncrease = new ArrayList<>();
        radioactiveBombIncrease.add(Input.Keys.G);
        clusterBombIncrease = new ArrayList<>();
        clusterBombIncrease.add(Input.Keys.CONTROL_LEFT);
        clusterBombIncrease.add(Input.Keys.CONTROL_RIGHT);
        tankIncrease = new ArrayList<>();
        tankIncrease.add(Input.Keys.T);
        revive = new ArrayList<>();
        revive.add(Input.Keys.H);
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

    public ArrayList<Integer> getClockWise() {
        return clockWise;
    }

    public ArrayList<Integer> getCounterClockWise() {
        return counterClockWise;
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

    public ArrayList<Integer> getNextWave() {
        return nextWave;
    }

    public ArrayList<Integer> getRadioactiveBombIncrease() {
        return radioactiveBombIncrease;
    }

    public ArrayList<Integer> getClusterBombIncrease() {
        return clusterBombIncrease;
    }

    public ArrayList<Integer> getTankIncrease() {
        return tankIncrease;
    }

    public ArrayList<Integer> getRevive() {
        return revive;
    }
}
