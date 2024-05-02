package com.model;

import com.badlogic.gdx.math.Vector2;

public class GameObject {
    protected Vector2 position;
    protected Vector2 velocity;
    protected int width;
    protected int height;
    public GameObject(Vector2 position, Vector2 velocity, int width, int height) {
        this.position = position;
        this.velocity = velocity;
        this.width = width;
        this.height = height;
    }
}
