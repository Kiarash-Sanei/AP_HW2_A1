package com.Model;

import java.util.HashMap;

public enum Keyboard {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    REGULAR_BOMB,
    RADIOACTIVE_BOMB,
    CLUSTER_BOMB,
    ICE_MODE;
    public static final HashMap<Keyboard, Boolean> status = new java.util.HashMap<>();
}
