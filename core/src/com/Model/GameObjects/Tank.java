package com.Model.GameObjects;

import com.Model.GameObject;
import com.Model.Setting;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Tank extends GameObject {
    private final float speed;
    private final float radius;
    private boolean isAlive = true;

    public Tank(float x, float y, float width, float height, Setting setting) {
        super(x, y, width, height);
        switch (setting.getDifficulty()) {
            case easy:
                speed = 10;
                radius = 100;
                break;
            case medium:
                speed = 20;
                radius = 200;
                break;
            case hard:
                speed = 30;
                radius = 300;
                break;
            default:
                speed = 0;
                radius = 0;
                break;
        }
        this.image = new Image(new Texture("GameObjects/Tank.png"));
        image.setHeight(height);
        image.setWidth(width);
        image.setPosition(x, y);
    }

    public void update(float deltaTime) {
        x -= speed * deltaTime;
        image.setPosition(x, y);
        wrapper();
    }

    public void wrapper() {
        if (x < 0)
            isAlive = false;
    }

    public void draw(SpriteBatch batch) {
        image.draw(batch, 1);
    }

    public boolean isAlive() {
        return isAlive;
    }
}
