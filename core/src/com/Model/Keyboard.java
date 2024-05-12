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
    NEXT_WAVE;
    public static final HashMap<Keyboard, Boolean> status = new java.util.HashMap<>();
}
