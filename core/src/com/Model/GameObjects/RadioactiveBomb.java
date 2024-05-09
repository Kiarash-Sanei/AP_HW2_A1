package com.Model.GameObjects;

import com.Model.GameObject;
import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class RadioactiveBomb extends GameObject {
    private static final float speed = 100;
    private boolean isAlive;

    public RadioactiveBomb(float x, float y, float width, float height) {
        super(x, y, width, height);
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            this.image = new Image(new Texture("GameObjects/B&W/RadioactiveBomb.png"));
        else
            this.image = new Image(new Texture("GameObjects/Colored/RadioactiveBomb.png"));
        image.setHeight(height);
        image.setWidth(width);
        this.isAlive = true;
    }

    public void update(float deltaTime) {
        y -= speed * deltaTime;
        wrapper();
        image.setPosition(x, y);
    }

    public void wrapper() {
        if (y < 0)
            isAlive = false;
    }

    public void draw(SpriteBatch batch) {
        image.draw(batch, 1);
    }

    public boolean isAlive() {
        return isAlive;
    }
    @Override
    public String toString() {
        return "RadioactiveBomb";
    }
}
