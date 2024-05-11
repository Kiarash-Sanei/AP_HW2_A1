package com.Model.GameObjects;

import com.Model.GameObject;
import com.Model.Setting;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.badlogic.gdx.Gdx.graphics;

public class Tank extends GameObject {
    private float speed;
    private final float radius;
    private boolean isAlive = true;
    private static final float height = 70;
    private static final float width = height * 1263 / 634;

    public Tank(float x, float y, Setting setting) {
        super(x, y);
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
        if (setting.getBlackAndWhite())
            this.image = new Image(new Texture("GameObjects/B&W/Tank.png"));
        else
            this.image = new Image(new Texture("GameObjects/Colored/Tank.png"));
        image.setHeight(height);
        image.setWidth(width);
        image.setPosition(x, y);
    }

    public void update(float deltaTime) {
        x += speed * deltaTime;
        image.setPosition(x, y);
        wrapper();
    }

    public void wrapper() {
        if (x > graphics.getWidth() - width)
            speed = -speed;
        else if (x < 0)
            speed = -speed;
    }

    public void draw(SpriteBatch batch) {
        image.draw(batch, 1);
    }

    public static float getHeight() {
        return height;
    }

    public static float getWidth() {
        return width;
    }

    @Override
    public boolean isOn(GameObject gameObject) {
        return gameObject.getY() <= this.y + height &&
                gameObject.getY() >= this.y &&
                gameObject.getX() >= this.x &&
                gameObject.getX() <= this.x + width;
    }
}
