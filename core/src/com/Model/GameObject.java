package com.Model;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class GameObject {
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected Image image;
    public GameObject(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
