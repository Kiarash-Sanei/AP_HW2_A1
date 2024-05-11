package com.Model.GameObjects;

import com.badlogic.gdx.physics.bullet.collision._btMprSimplex_t;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

public abstract class GameObject {
    private static final ArrayList<GameObject> gameObjects = new ArrayList<>();
    protected float x;
    protected float y;
    protected float velocityX;
    protected float velocityY;
    protected float accelerationX;
    protected float accelerationY;
    protected float angle;
    protected float angularVelocity;
    protected final float g = -150;
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

    public boolean isOn(GameObject gameObject) {//TODO: It is not working.
        return (gameObject.getY() <= y + this.image.getHeight() &&
                gameObject.getY() >= y &&
                gameObject.getX() >= x &&
                gameObject.getX() <= x + this.image.getWidth()) ||
                (gameObject.getY() <= y + this.image.getHeight() &&
                        gameObject.getY() >= y &&
                        gameObject.getX() + gameObject.image.getWidth() >= x &&
                        gameObject.getX() + gameObject.image.getWidth() <= x + this.image.getWidth()) ||
                (gameObject.getY() + gameObject.image.getHeight() <= y + this.image.getHeight() &&
                        gameObject.getY() + gameObject.image.getHeight() >= y &&
                        gameObject.getX() >= x &&
                        gameObject.getX() <= x + this.image.getWidth()) ||
                (gameObject.getY() + gameObject.image.getHeight() <= y + this.image.getHeight() &&
                        gameObject.getY() + gameObject.image.getHeight() >= y &&
                        gameObject.getX() + gameObject.image.getWidth() >= x &&
                        gameObject.getX() + gameObject.image.getWidth() <= x + this.image.getWidth());
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public float getAccelerationX() {
        return accelerationX;
    }

    public float getAccelerationY() {
        return accelerationY;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void kill() {
        isAlive = false;
    }
}
