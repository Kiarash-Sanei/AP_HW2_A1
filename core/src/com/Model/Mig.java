package com.Model;

public class Mig extends GameObject {
    private final float period;
    private final float radius;
    private final float speed = 2000;

    public Mig(float x, float y, float width, float height, Setting setting) {
        super(x, y, width, height);
        switch (setting.getDifficulty()) {
            case easy:
                period = 5;
                radius = 100;
                break;
            case medium:
                period = (float) (0.75 * 5);
                radius = 200;
                break;
            case hard:
                period = (float) (0.5 * 5);
                radius = 300;
                break;
            default:
                period = 0;
                radius = 0;
                break;
        }
    }
}
