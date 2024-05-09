package com.Model.GameObjects;

import com.Model.GameObject;
import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Building extends GameObject {


    private boolean isAlive;

    public Building(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.isAlive = true;
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            this.image = new Image(new Texture("GameObjects/B&W/Building.png"));
        else
            this.image = new Image(new Texture("GameObjects/Colored/Building.png"));
        image.setHeight(height);
        image.setWidth(width);
        image.setPosition(x, y);
    }

    public void update(float deltaTime) {

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
