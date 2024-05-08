package com.Model;

public enum Difficulty {
    easy(1),
    medium(2),
    hard(3);
    private final int value;

    Difficulty(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
