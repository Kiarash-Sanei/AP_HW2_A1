package com.Model;

import java.util.HashMap;

public enum Keyboard {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    CLOCK_WISE,
    COUNTER_CLOCK_WISE,
    REGULAR_BOMB,
    RADIOACTIVE_BOMB,
    CLUSTER_BOMB,
    ICE_MODE,
    NEXT_WAVE,
    RADIOACTIVE_BOMB_INCREASE,
    CLUSTER_BOMB_INCREASE,
    TANK_INCREASE,
    REVIVE,
    PAUSE;
    public static final HashMap<Keyboard, Boolean> status = new java.util.HashMap<>();

    static {
        for (Keyboard key : Keyboard.values())
            Keyboard.status.put(key, false);
    }

    public static Keyboard toKeyboard(int keyCode, Setting setting) {
        if (setting.getUp().contains(keyCode))
            return Keyboard.UP;
        if (setting.getDown().contains(keyCode))
            return Keyboard.DOWN;
        if (setting.getRight().contains(keyCode))
            return Keyboard.RIGHT;
        if (setting.getLeft().contains(keyCode))
            return Keyboard.LEFT;
        if (setting.getClockWise().contains(keyCode))
            return Keyboard.CLOCK_WISE;
        if (setting.getCounterClockWise().contains(keyCode))
            return Keyboard.COUNTER_CLOCK_WISE;
        if (setting.getRegularBomb().contains(keyCode))
            return Keyboard.REGULAR_BOMB;
        if (setting.getRadioactiveBomb().contains(keyCode))
            return Keyboard.RADIOACTIVE_BOMB;
        if (setting.getClusterBomb().contains(keyCode))
            return Keyboard.CLUSTER_BOMB;
        if (setting.getIceMode().contains(keyCode))
            return Keyboard.ICE_MODE;
        if (setting.getNextWave().contains(keyCode))
            return Keyboard.NEXT_WAVE;
        if (setting.getRadioactiveBombIncrease().contains(keyCode))
            return Keyboard.RADIOACTIVE_BOMB_INCREASE;
        if (setting.getClusterBombIncrease().contains(keyCode))
            return Keyboard.CLUSTER_BOMB_INCREASE;
        if (setting.getTankIncrease().contains(keyCode))
            return Keyboard.TANK_INCREASE;
        if (setting.getRevive().contains(keyCode))
            return Keyboard.REVIVE;
        if (setting.getPause().contains(keyCode))
            return Keyboard.PAUSE;
        return null;
    }

    public static boolean keyDown(int keyCode, Setting setting) {
        Keyboard keyboardAction = toKeyboard(keyCode, setting);
        if (keyboardAction != null) {
            Keyboard.status.put(keyboardAction, true);
            return true;
        }
        return false;
    }

    public static boolean keyUp(int keyCode, Setting setting) {
        Keyboard keyboardAction = toKeyboard(keyCode, setting);
        if (keyboardAction != null) {
            Keyboard.status.put(keyboardAction, false);
            return true;
        }
        return false;
    }
}
