package com.Model.GameObjects;

import com.Model.Setting;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.badlogic.gdx.Gdx.graphics;

public class Tank extends GameObject {
    private float speed;
    private final float radius;

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
        image.setHeight(GameObjects.Tank.getHeight());
        image.setWidth(GameObjects.Tank.getWidth());
        image.setPosition(x, y);
    }

    public void update(float deltaTime) {
        x += speed * deltaTime;
        image.setPosition(x, y);
        wrapper();
    }

    public void wrapper() {
        if (x > graphics.getWidth() - GameObjects.Tank.getWidth())
            speed = -speed;
        else if (x < 0)
            speed = -speed;
    }

    public void draw(SpriteBatch batch) {
        image.draw(batch, 1);
    }
}
