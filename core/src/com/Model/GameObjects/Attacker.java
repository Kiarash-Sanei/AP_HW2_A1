package com.Model.GameObjects;

public abstract class Attacker extends GameObject {
    protected float time;

    public Attacker(float x, float y) {
        super(x, y);
        time = 5;
    }

    public abstract float getRadius();

    public abstract void attack(Plane plane);
}
