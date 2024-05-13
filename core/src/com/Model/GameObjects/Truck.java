package com.Model.GameObjects;

import com.Model.User;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.badlogic.gdx.Gdx.graphics;

public class Truck extends GameObject {
    private Image imageIce;

    public Truck(float x, float y) {
        super(x, y);
        if (User.getCurrentUser().getSetting().getBlackAndWhite()) {
            this.image = new Image(new Texture("GameObjects/B&W/Truck.png"));
            this.imageIce = new Image(new Texture("GameObjects/B&W/Truck.png"));
        } else {
            this.image = new Image(new Texture("GameObjects/Colored/Truck.png"));
            this.imageIce = new Image(new Texture("GameObjects/Colored/Truck.png"));
            imageIce.setColor(Color.CYAN);
        }
        image.setHeight(GameObjects.Truck.getHeight());
        image.setWidth(GameObjects.Truck.getWidth());
        image.setPosition(x, y);
        imageIce.setHeight(GameObjects.Truck.getHeight());
        imageIce.setWidth(GameObjects.Truck.getWidth());
        velocityX = 10;
    }

    public void update(float deltaTime, boolean iceMode) {
        if (!iceMode) {
            x += velocityX * deltaTime;
            image.setPosition(x, y);
            wrapper();
        }
    }

    public void wrapper() {
        if (x > graphics.getWidth() - GameObjects.Truck.getWidth() || x < 0)
            velocityX = -velocityX;
    }

    public void draw(SpriteBatch batch, boolean iceMode) {
        if (iceMode) {
            imageIce.setPosition(image.getX(), image.getY());
            imageIce.draw(batch, 1);
        } else
            image.draw(batch, 1);
    }
}
