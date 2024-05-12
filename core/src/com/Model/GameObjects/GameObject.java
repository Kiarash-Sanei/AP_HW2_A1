package com.Model.GameObjects;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

public abstract class GameObject {
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
        this.isAlive = true;
        this.x = x;
        this.y = y;
    }

    public boolean isOn(GameObject gameObject) {
        return ((gameObject.y <= y + this.image.getHeight() &&
                gameObject.y >= y &&
                gameObject.x <= x + this.image.getWidth() &&
                gameObject.x >= x) ||
                (gameObject.y <= y + this.image.getHeight() &&
                        gameObject.y >= y &&
                        gameObject.x + gameObject.image.getWidth() <= x + this.image.getWidth() &&
                        gameObject.x + gameObject.image.getWidth() >= x) ||
                (gameObject.y + gameObject.image.getHeight() <= y + this.image.getHeight() &&
                        gameObject.y + gameObject.image.getHeight() >= y &&
                        gameObject.x <= x + this.image.getWidth() &&
                        gameObject.x >= x) ||
                (gameObject.y + gameObject.image.getHeight() <= y + this.image.getHeight() &&
                        gameObject.y + gameObject.image.getHeight() >= y &&
                        gameObject.x + gameObject.image.getWidth() <= x + this.image.getWidth() &&
                        gameObject.x + gameObject.image.getWidth() >= x)) &&
                this.isAlive &&
                gameObject.isAlive;
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
