package com.Model.GameObjects;

import com.Model.GameObject;
import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.badlogic.gdx.Gdx.graphics;

public class Truck extends GameObject {
    private boolean isAlive;
    private float speed = 10;

    public Truck(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.isAlive = true;
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            this.image = new Image(new Texture("GameObjects/B&W/Truck.png"));
        else
            this.image = new Image(new Texture("GameObjects/Colored/Truck.png"));
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

    public boolean isAlive() {
        return isAlive;
    }
    public void setAlive(boolean life) {
        isAlive = life;
    }
}
