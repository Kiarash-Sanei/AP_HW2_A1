package com.Model.GameObjects;

import com.Model.GameObject;
import com.Model.Setting;
import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Mig extends GameObject {
    private final float period;
    private final float radius;
    private final float speed = 200;
    private boolean isAlive = true;

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
        if (setting.getBlackAndWhite())
            this.image = new Image(new Texture("GameObjects/B&W/Mig.png"));
        else
            this.image = new Image(new Texture("GameObjects/Colored/Mig.png"));
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
