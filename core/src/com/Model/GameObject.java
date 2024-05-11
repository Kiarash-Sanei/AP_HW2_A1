package com.Model;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

public abstract class GameObject {
    private static final ArrayList<GameObject> gameObjects = new ArrayList<>();
    protected float x;
    protected float y;
    protected Image image;
    protected boolean isAlive;

    public GameObject(float x, float y) {
        gameObjects.add(this);
        this.isAlive = true;
        this.x = x;
        this.y = y;
    }

    public static ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public abstract boolean isOn(GameObject gameObject);

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void kill() {
        isAlive = false;
    }
}
