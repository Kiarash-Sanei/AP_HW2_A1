package com.Model.GameObjects;

import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Bonus extends GameObject {
    public Bonus(float x, float y) {
        super(x, y);
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            image = new Image(new Texture("Bonus/B&W/Bonus.png"));
        else
            image = new Image(new Texture("Bonus/Colored/Bonus.png"));
        image.setHeight(GameObjects.Bonus.getHeight());
        image.setWidth(GameObjects.Bonus.getWidth());
        image.setPosition(x, y);
    }

    public void update(float deltaTime) {

    }

    public void draw(SpriteBatch batch) {
        image.draw(batch, 1);
    }
}
